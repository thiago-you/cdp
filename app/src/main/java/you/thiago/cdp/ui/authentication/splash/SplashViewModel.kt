package you.thiago.cdp.ui.authentication.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class SplashViewModel : ViewModel() {

    private val _loading = MutableStateFlow(true)
    val loading: StateFlow<Boolean> = _loading

    fun startLoading() {
        viewModelScope.launch(Dispatchers.IO) {
            Thread.sleep(2000)

            _loading.value = false
        }
    }
}