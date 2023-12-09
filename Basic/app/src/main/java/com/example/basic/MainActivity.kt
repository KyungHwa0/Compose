package com.example.basic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.basic.ui.theme.BasicTheme


// Image
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasicTheme {
                MyImageWeb()
            }
        }
    }
}

@Composable
fun MyImage() {
    Image(
        painter = painterResource(id = R.drawable.pro),
        contentDescription = "pro"
    )
}


//https://private-user-images.githubusercontent.com/124041716/284048454-23926794-adb1-4632-b800-f31a7d4d45c3.png?jwt=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTEiLCJleHAiOjE3MDIxMjM1MTMsIm5iZiI6MTcwMjEyMzIxMywicGF0aCI6Ii8xMjQwNDE3MTYvMjg0MDQ4NDU0LTIzOTI2Nzk0LWFkYjEtNDYzMi1iODAwLWYzMWE3ZDRkNDVjMy5wbmc_WC1BbXotQWxnb3JpdGhtPUFXUzQtSE1BQy1TSEEyNTYmWC1BbXotQ3JlZGVudGlhbD1BS0lBSVdOSllBWDRDU1ZFSDUzQSUyRjIwMjMxMjA5JTJGdXMtZWFzdC0xJTJGczMlMkZhd3M0X3JlcXVlc3QmWC1BbXotRGF0ZT0yMDIzMTIwOVQxMjAwMTNaJlgtQW16LUV4cGlyZXM9MzAwJlgtQW16LVNpZ25hdHVyZT02MDMxMmQ3YmI0ZWYzMTBhOThkYzhlMDJiOTNlMmY5M2UzYmFhMmIwNzE3MzA1ZDhlN2NiMzEwNjUyYmI5Yjk4JlgtQW16LVNpZ25lZEhlYWRlcnM9aG9zdCZhY3Rvcl9pZD0wJmtleV9pZD0wJnJlcG9faWQ9MCJ9.VlqWjq-gyvmjXqNMM3uaeQyat_ZxBvyNoiaE8pobXvY
@Composable
fun MyImageWeb() {
    AsyncImage(
        model = "https://private-user-images.githubusercontent.com/124041716/284048454-23926794-adb1-4632-b800-f31a7d4d45c3.png?jwt=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTEiLCJleHAiOjE3MDIxMjM1MTMsIm5iZiI6MTcwMjEyMzIxMywicGF0aCI6Ii8xMjQwNDE3MTYvMjg0MDQ4NDU0LTIzOTI2Nzk0LWFkYjEtNDYzMi1iODAwLWYzMWE3ZDRkNDVjMy5wbmc_WC1BbXotQWxnb3JpdGhtPUFXUzQtSE1BQy1TSEEyNTYmWC1BbXotQ3JlZGVudGlhbD1BS0lBSVdOSllBWDRDU1ZFSDUzQSUyRjIwMjMxMjA5JTJGdXMtZWFzdC0xJTJGczMlMkZhd3M0X3JlcXVlc3QmWC1BbXotRGF0ZT0yMDIzMTIwOVQxMjAwMTNaJlgtQW16LUV4cGlyZXM9MzAwJlgtQW16LVNpZ25hdHVyZT02MDMxMmQ3YmI0ZWYzMTBhOThkYzhlMDJiOTNlMmY5M2UzYmFhMmIwNzE3MzA1ZDhlN2NiMzEwNjUyYmI5Yjk4JlgtQW16LVNpZ25lZEhlYWRlcnM9aG9zdCZhY3Rvcl9pZD0wJmtleV9pZD0wJnJlcG9faWQ9MCJ9.VlqWjq-gyvmjXqNMM3uaeQyat_ZxBvyNoiaE8pobXvY",
        contentDescription = "두툼",
        modifier = Modifier.fillMaxSize()
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BasicTheme {
        MyImageWeb()
    }
}
