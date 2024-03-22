package com.wack.dropdown

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.wack.dropdown.ui.theme.DropDownTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DropDownTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    DropDownMenu()
                }
            }
        }
    }
}

@Composable
fun DropDownMenu() {
    var expandDropDownMenu by remember { mutableStateOf(false) }
    var counter by remember { mutableStateOf(0) }

    val coroutineScope = rememberCoroutineScope()
    val scaffoldState = rememberScaffoldState()

    Scaffold(scaffoldState = scaffoldState) {

        Column {
            Button(onClick = { expandDropDownMenu = true }) {
                Text("드롭다운 메뉴 열기")
            }
            Text("카운터: $counter")
        }


        DropdownMenu(
            expanded = expandDropDownMenu,
            onDismissRequest = { expandDropDownMenu = false }) {
            DropdownMenuItem(onClick = {
                counter++
                coroutineScope.launch {
                    scaffoldState.snackbarHostState.showSnackbar(
                        "카운터: $counter",
                        actionLabel = "닫기",
                        duration = SnackbarDuration.Short
                    )
                }
            }) {
                Text("+1")
            }
            DropdownMenuItem(onClick = {
                counter--
            }) {
                Text("-1")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    DropDownTheme {
        DropDownMenu()
    }
}