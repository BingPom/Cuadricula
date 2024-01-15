package com.example.cuadricula

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cuadricula.data.DataSource
import com.example.cuadricula.model.Item
import com.example.cuadricula.ui.theme.CuadriculaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CuadriculaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CuadriculaMain()
                }
            }
        }
    }
}

@Composable
fun CuadriculaMain(modifier: Modifier = Modifier) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.fillMaxSize()
    ) {
        items(DataSource.items) { item ->
            CuadriculaItem(item)
        }
    }
}

@Composable
fun CuadriculaItem(item: Item) {
    Card(
        modifier = Modifier.padding(8.dp)
    ) {
        Row {
            Image(
                painter = painterResource(id = item.image),
                contentDescription = null,
                modifier = Modifier.size(68.dp),
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier.padding(top = 16.dp, end = 16.dp)
            ) {
                Text(
                    text = stringResource(id = item.text),
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(bottom = 8.dp, start = 16.dp)
                )
                Row {
                    Icon(
                        painter = painterResource(id = R.drawable.grain),
                        contentDescription = "Number of followers",
                        modifier = Modifier.padding(start = 16.dp, end = 8.dp)
                    )
                    Text(
                        text = item.followersNumber.toString(),
                        style = MaterialTheme.typography.labelMedium
                    )
                }

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CuadriculaTheme {
        CuadriculaMain()
    }
}