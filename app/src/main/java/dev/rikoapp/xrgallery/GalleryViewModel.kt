package dev.rikoapp.xrgallery

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class GalleryViewModel : ViewModel() {

    var state by mutableStateOf(GalleryState(100, "100"))
        private set

    fun changeGallerySizeInput(input: String) {
        state = state.copy(lobbyInput = input)

        changeGallerySize(input.toIntOrNull() ?: 1)
    }

    private fun changeGallerySize(newSize: Int) {
        state = state.copy(gallerySize = newSize)
    }
}