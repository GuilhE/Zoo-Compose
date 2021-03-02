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
package com.github.guilhe.zoocompose.data.manager

import com.github.guilhe.zoocompose.R
import com.github.guilhe.zoocompose.data.model.Animal

class AnimalManager {
    fun animalList() = listOf(
        Animal(R.string.bat_name, R.drawable.bat, R.string.bat_desc),
        Animal(R.string.cat_name, R.drawable.cat, R.string.cat_desc),
        Animal(R.string.chicken_name, R.drawable.chicken, R.string.chicken_desc),
        Animal(R.string.crab_name, R.drawable.crab, R.string.crab_desc),
        Animal(R.string.crocodile_name, R.drawable.crocodile, R.string.crocodile_desc),
        Animal(R.string.dino_name, R.drawable.dino, R.string.dino_desc),
        Animal(R.string.dog_name, R.drawable.dog, R.string.dog_desc),
        Animal(R.string.eagle_name, R.drawable.eagle, R.string.eagle_desc),
        Animal(R.string.fish_name, R.drawable.fish, R.string.fish_desc),
        Animal(R.string.fox_name, R.drawable.fox, R.string.fox_desc),
        Animal(R.string.frog_name, R.drawable.frog, R.string.frog_desc),
        Animal(R.string.lion_name, R.drawable.lion, R.string.lion_desc),
        Animal(R.string.mouse_name, R.drawable.mouse, R.string.mouse_desc),
        Animal(R.string.rabbit_name, R.drawable.rabbit, R.string.rabbit_desc),
        Animal(R.string.shark_name, R.drawable.shark, R.string.shark_desc),
        Animal(R.string.snake_name, R.drawable.snake, R.string.snake_desc),
        Animal(R.string.spider_name, R.drawable.spider, R.string.spider_desc),
        Animal(R.string.turtle_name, R.drawable.turtle, R.string.turtle_desc),
        Animal(R.string.wolf_name, R.drawable.wolf, R.string.wolf_desc)
    )
}
