package com.example.estudos_jetpack_compose

import androidx.activity.viewModels
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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.data.EmptyGroup.name
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController

@Composable
fun MainScreen(navController: NavHostController) {
    val appModel: AppModel = viewModel()
    BoxWithConstraints() {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            val appState by appModel.appState.collectAsState()
            Text(text = "Main Screen", fontSize = 40.sp, color = Color.Blue)
            MainScreenInput(name = appState.name)
            MainScreenButton(name = name, showOutput = showOutput, navController = navController)

            if (showOutput.value && name.value != null)
                Text("Valor: ${name.value}")
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreenInput(name: String?) {
    val input = remember { mutableStateOf("") }
    TextField(value = name ?: "",
        onValueChange = { input.value = it },
        singleLine = true,
        shape = RoundedCornerShape(30.dp),
        label = { Text(text = "Nome") },
        colors = TextFieldDefaults.textFieldColors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        placeholder = { Text(text = "Ex: Arthur Marques") }
    )
}

@Composable
fun MainScreenButton(name: MutableState<String?>, showOutput: MutableState<Boolean>, navController: NavHostController) {
    Button(onClick = {
        showOutput.value = !showOutput.value;
        if (!showOutput.value) {
            name.value = null;
        }
        navController.navigate(route = Second.route)
    }, modifier = Modifier.size(height = 60.dp, width = 200.dp)) {
        Text(text = "Enviar", fontSize = 20.sp, color = Color.White)
    }
}