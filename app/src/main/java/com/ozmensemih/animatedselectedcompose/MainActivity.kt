package com.ozmensemih.animatedselectedcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ozmensemih.animatedselectedcompose.ui.theme.AnimatedSelectedComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AnimatedSelectedComposeTheme {

                var selected by remember{ mutableStateOf(false) }
                var selected2 by remember {mutableStateOf(false) }

               Column (modifier = Modifier
                   .fillMaxSize()
                   .padding(12.dp),
                   verticalArrangement = Arrangement.Center,
                   horizontalAlignment = Alignment.CenterHorizontally) {

                   SelectableItems(selected = selected, title = "Lorem upseees",
                       onclick = {
                           selected= !selected
                       })
                    Spacer(modifier = Modifier.height(12.dp))

                   SelectableItems(selected = selected2, title = "Lorem upsees",
                       subTitle = "naber nasılsın. Çalış bakalım nasıl çalışıyor.",
                       onclick = {
                           selected2= !selected2
                       })

               }
            }
        }
    }
}
