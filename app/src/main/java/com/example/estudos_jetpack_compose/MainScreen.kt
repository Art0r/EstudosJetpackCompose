package com.example.estudos_jetpack_compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MainScreen() {
    BoxWithConstraints() {
        val name: MutableState<String?> = remember { mutableStateOf(null) }
        val showOutput: MutableState<Boolean> = remember { mutableStateOf(false) }
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            Text(text = "Main Screen", fontSize = 40.sp, color = Color.Blue)
            MainScreenInput(name = name)
            MainScreenButton(name = name, showOutput = showOutput)
            if (showOutput.value && name.value != null)
            Text("Valor: ${name.value}")
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreenInput(name: MutableState<String?>) {
    TextField(value = name.value ?: "",
        onValueChange = { name.value = it },
        singleLine = true,
        shape = RoundedCornerShape(30.dp),
        label = { Text(text = "Insira a informação") },
        colors = TextFieldDefaults.textFieldColors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        )
    )
}

@Composable
fun MainScreenButton(name: MutableState<String?>, showOutput: MutableState<Boolean>) {
    Button(onClick = {
        showOutput.value = !showOutput.value;
        if (!showOutput.value) {
            name.value = null;
        }
    }, modifier = Modifier.size(height = 60.dp, width = 200.dp)) {
        Text(text = "Enviar", fontSize = 20.sp, color = Color.White)
    }
}

@Preview
@Composable
fun MainScreenPreview() {
    Surface {
        MainScreen()
    }
}
