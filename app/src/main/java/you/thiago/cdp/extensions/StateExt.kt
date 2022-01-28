package you.thiago.cdp.extensions

import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

fun <T> LifecycleOwner.collect(flow: StateFlow<T>, lifecycleState: Lifecycle.State = Lifecycle.State.STARTED, action: suspend (value: T) -> Unit) {
    lifecycleScope.launch {
        repeatOnLifecycle(lifecycleState) {
            flow.collect { action(it) }
        }
    }
}

fun <T> Fragment.collect(flow: StateFlow<T>, lifecycleState: Lifecycle.State = Lifecycle.State.STARTED, action: suspend (value: T) -> Unit) {
    viewLifecycleOwner.lifecycleScope.launch {
        repeatOnLifecycle(lifecycleState) {
            flow.collect { action(it) }
        }
    }
}

fun <T> Fragment.collect(flow: SharedFlow<T>, lifecycleState: Lifecycle.State = Lifecycle.State.STARTED, action: suspend (value: T) -> Unit) {
    viewLifecycleOwner.lifecycleScope.launch {
        repeatOnLifecycle(lifecycleState) {
            flow.collect { action(it) }
        }
    }
}