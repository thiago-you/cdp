package you.thiago.cdp.ui.authentication.register

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import you.thiago.cdp.databinding.FragmentRegisterBinding

class RegisterFragment : Fragment() {

    private lateinit var registerViewModel: RegisterViewModel
    private var _binding: FragmentRegisterBinding? = null

    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        registerViewModel = ViewModelProvider(this)[RegisterViewModel::class.java]

        _binding = FragmentRegisterBinding.inflate(inflater, container, false)

        val root: View = binding.root
        val textView: TextView = binding.textGallery

        registerViewModel.text.observe(viewLifecycleOwner, { textView.text = it })

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}