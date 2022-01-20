package you.thiago.cdp.ui.authentication.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import you.thiago.cdp.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private lateinit var slideshowViewModel: LoginViewModel
    private var _binding: FragmentLoginBinding? = null

    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        slideshowViewModel = ViewModelProvider(this)[LoginViewModel::class.java]

        _binding = FragmentLoginBinding.inflate(inflater, container, false)

        val root: View = binding.root
        val textView: TextView = binding.textSlideshow

        slideshowViewModel.text.observe(viewLifecycleOwner, { textView.text = it })

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}