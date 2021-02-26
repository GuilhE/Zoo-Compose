/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.repository.Animal
import com.example.androiddevchallenge.repository.DataSource

@Composable
private fun AppBar(title: String = stringResource(R.string.app_name)) {
    TopAppBar(
        title = { Text(text = title) },
        backgroundColor = MaterialTheme.colors.primary
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun AnimalList(onSelected: (Animal) -> Unit) {
    val animals = remember { DataSource.animalList() }
    Surface(color = MaterialTheme.colors.background) {
        Scaffold(topBar = { AppBar() }) {
            LazyVerticalGrid(cells = GridCells.Adaptive(minSize = 130.dp)) {
                items(animals) { AnimalListItem(it) { animal -> onSelected.invoke(animal) } }
            }
        }
    }
}

@Composable
fun AnimalListItem(animal: Animal, onSelected: (Animal) -> Unit) {
    Box {
        Card(
            shape = RoundedCornerShape(8.dp),
            elevation = 2.dp,
            modifier = Modifier
                .size(150.dp)
                .padding(PaddingValues(10.dp))
                .clickable { onSelected.invoke(animal) }
        ) {
            Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    painter = painterResource(animal.image),
                    contentDescription = animal.name,
                    modifier = Modifier.size(100.dp)
                )
                Text(animal.name, textAlign = TextAlign.Center, style = MaterialTheme.typography.body1, fontWeight = FontWeight.Bold)
            }
        }
    }
}

@Composable
@Preview
fun MockList() {
    AnimalList {}
}

@Composable
@Preview
fun MockListItem() {
    AnimalListItem(
        Animal(
            "Crocodile",
            R.drawable.crocodile,
            "Crocodiles (subfamily Crocodylinae) or true crocodiles are large semiaquatic reptiles that live throughout the tropics in Africa, Asia, the Americas and Australia."
        )
    ) {}
}
