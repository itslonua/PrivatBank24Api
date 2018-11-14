package mobile.privatbank24api.utils


sealed class ResultViewState {

    object InFlight : ResultViewState()
    data class Success<out T>(val result: T) : ResultViewState()
    data class Error(val throwable: Throwable) : ResultViewState()

}

