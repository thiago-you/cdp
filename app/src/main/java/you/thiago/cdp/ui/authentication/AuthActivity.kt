package you.thiago.cdp.ui.authentication

import android.os.Bundle
import android.view.Menu
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import dagger.hilt.android.AndroidEntryPoint
import you.thiago.cdp.R
import you.thiago.cdp.databinding.ActivityAuthBinding

@AndroidEntryPoint
class AuthActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAuthBinding

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAuthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupNavigationController()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean = true

    private fun setupNavigationController() {
        (supportFragmentManager.findFragmentById(R.id.nav_host_fragment_content_auth) as NavHostFragment).also {
            navController = it.navController
        }
    }
}