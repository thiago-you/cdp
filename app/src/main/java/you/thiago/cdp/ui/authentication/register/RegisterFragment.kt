package you.thiago.cdp.ui.authentication.register

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.AndroidEntryPoint
import you.thiago.cdp.R
import you.thiago.cdp.databinding.FragmentRegisterBinding
import you.thiago.cdp.extensions.collect

@AndroidEntryPoint
class RegisterFragment : Fragment() {

    private var _binding: FragmentRegisterBinding? = null

    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!

    private lateinit var auth: FirebaseAuth

    private val registerViewModel: RegisterViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)

        requireActivity().window?.statusBarColor = ContextCompat.getColor(requireContext(), R.color.dark_sky)

        auth = Firebase.auth

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            form = registerViewModel.signUpForm.value
            lifecycleOwner = viewLifecycleOwner
        }

        setupInterface()
        setupListeners()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setupInterface() {
        binding.btnSignUp.setOnClickListener {
            registerViewModel.signUp()
        }

        binding.btnSignIn.setOnClickListener {
            binding.root.findNavController().navigate(R.id.nav_login)
        }
    }

    private fun setupListeners() {
        collect(registerViewModel.signUpResult) { result ->
            if (result.success != null) {
                showLoggedUser(result.success)
            } else if (result.error != null) {
                showError(result.error)
            }
        }

        collect(registerViewModel.signUpFormState) { formState ->
            binding.btnSignUp.isEnabled = formState.isDataValid

            when {
                formState.emailError != null -> {
                    binding.txtEmail.error = getString(formState.emailError)
                }
                formState.nameError != null -> {
                    binding.txtName.error = getString(formState.nameError)
                }
                formState.passwordError != null -> {
                    binding.txtPassword.error = getString(formState.passwordError)
                }
            }
        }
    }

    private fun showLoggedUser(username: String) {
        Toast.makeText(requireContext(), getString(R.string.sign_up_success, username), Toast.LENGTH_SHORT).show()
    }

    private fun showError(@StringRes errorRes: Int) {
        Toast.makeText(requireContext(), getString(errorRes), Toast.LENGTH_SHORT).show()
    }
}