package you.thiago.cdp.ui.authentication.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class SplashViewModel : ViewModel() {

    private val _redirect = MutableStateFlow<RedirectEnum?>(null)
    val redirect: StateFlow<RedirectEnum?> = _redirect

    private var auth: FirebaseAuth = Firebase.auth

    fun startLoading() {
        viewModelScope.launch(Dispatchers.IO) {
            Thread.sleep(2000)

            if (auth.currentUser != null) {
                _redirect.value = RedirectEnum.HOME
            } else {
                _redirect.value = RedirectEnum.REGISTER
            }
        }
    }
}