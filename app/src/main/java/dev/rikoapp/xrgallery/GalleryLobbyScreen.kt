package dev.rikoapp.xrgallery

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@Composable
fun GalleryLobbyScreen(
    onEnterGallery: () -> Unit,
    viewModel: GalleryViewModel,
    modifier: Modifier = Modifier
) {
    val state = viewModel.state

    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .height(400.dp)
                .padding(horizontal = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = stringResource(id = R.string.gallery_lobby_title),
                style = MaterialTheme.typography.headlineMedium
            )
            Spacer(modifier = Modifier.height(24.dp))
            OutlinedTextField(
                value = state.gallerySize.toString(),
                onValueChange = {
                    viewModel.changeGallerySizeInput(it)
                },
                label = {
                    Text(text = stringResource(id = R.string.gallery_lobby_input_hint))
                },
                modifier = Modifier.padding(horizontal = 16.dp),
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number
                )
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = { onEnterGallery() }
            ) {
                Text(
                    text = stringResource(id = R.string.gallery_lobby_enter_button),
                    style = MaterialTheme.typography.labelLarge
                )
            }
        }
    }
}