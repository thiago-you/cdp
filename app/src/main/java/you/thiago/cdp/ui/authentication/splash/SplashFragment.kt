package you.thiago.cdp.ui.authentication.splash

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import you.thiago.cdp.R
import you.thiago.cdp.databinding.FragmentSplashBinding
import you.thiago.cdp.extensions.collect

class SplashFragment : Fragment() {

    private lateinit var splashViewModel: SplashViewModel
    private var _binding: FragmentSplashBinding? = null

    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!

    private lateinit var navController: NavController

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        splashViewModel = ViewModelProvider(this)[SplashViewModel::class.java]

        _binding = FragmentSplashBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupNavController()
        setupListeners()

        splashViewModel.startLoading()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setupNavController() {
        navController = findNavController()
    }

    private fun setupListeners() {
        collect(splashViewModel.loading) { loading ->
            if (!loading) {
                navController.navigate(R.id.nav_register)
            }
        }
    }
}