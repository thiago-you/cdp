package you.thiago.cdp.ui.authentication.splash

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import you.thiago.cdp.R
import you.thiago.cdp.databinding.FragmentSplashBinding
import you.thiago.cdp.extensions.collect

class SplashFragment : Fragment() {

    private lateinit var splashViewModel: SplashViewModel
    private var _binding: FragmentSplashBinding? = null

    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        splashViewModel = ViewModelProvider(this)[SplashViewModel::class.java]

        _binding = FragmentSplashBinding.inflate(inflater, container, false)

        requireActivity().window?.statusBarColor = ContextCompat.getColor(requireContext(), R.color.dark_sky)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupListeners()

        splashViewModel.startLoading()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setupListeners() {
        collect(splashViewModel.loading) { loading ->
            if (!loading) {
                binding.root.findNavController().navigate(R.id.nav_register)
            }
        }
    }
}