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
package com.example.androiddevchallenge.repository

import androidx.annotation.DrawableRes
import com.example.androiddevchallenge.R

data class Animal(val name: String, @DrawableRes val image: Int, val description: String)

object DataSource {
    fun animalList() = listOf(
        Animal(
            "Bat",
            R.drawable.bat,
            "Bats are mammals of the order Chiroptera. With their forelimbs adapted as wings, they are the only mammals capable of true and sustained flight. Bats are more manoeuvrable than birds, flying with their very long spread-out digits covered with a thin membrane or patagium. The smallest bat, and arguably the smallest extant mammal, is Kitti's hog-nosed bat, which is 29–34 millimetres (1 1⁄8–1 3⁄8 inches) in length, 150 mm (6 in) across the wings and 2–2.6 g (1⁄16–3⁄32 oz) in mass. The largest bats are the flying foxes and the giant golden-crowned flying fox, Acerodon jubatus, which can weigh 1.6 kg (3 1⁄2 lb) and have a wingspan of 1.7 m (5 ft 7 in).\n" +
                "\n" +
                "The second largest order of mammals after rodents, bats comprise about 20% of all classified mammal species worldwide, with over 1,400 species. These were traditionally divided into two suborders: the largely fruit-eating megabats, and the echolocating microbats. But more recent evidence has supported dividing the order into Yinpterochiroptera and Yangochiroptera, with megabats as members of the former along with several species of microbats. Many bats are insectivores, and most of the rest are frugivores (fruit-eaters) or nectarivores (nectar-eaters). A few species feed on animals other than insects; for example, the vampire bats feed on blood. Most bats are nocturnal, and many roost in caves or other refuges; it is uncertain whether bats have these behaviours to escape predators. Bats are present throughout the world, with the exception of extremely cold regions. They are important in their ecosystems for pollinating flowers and dispersing seeds; many tropical plants depend entirely on bats for these services."
        ),
        Animal(
            "Cat",
            R.drawable.cat,
            "The cat (Felis catus) is a domestic species of small carnivorous mammal. It is the only domesticated species in the family Felidae and is often referred to as the domestic cat to distinguish it from the wild members of the family."
        ),
        Animal(
            "Chicken",
            R.drawable.chicken,
            "The chicken (Gallus gallus domesticus), a subspecies of the red junglefowl, is a type of domesticated fowl."
        ),
        Animal(
            "Crab",
            R.drawable.crab,
            "Crabs are decapod crustaceans of the infraorder Brachyura, which typically have a very short projecting \"tail\" (abdomen), usually hidden entirely under the thorax. They live in all the world's oceans, in fresh water, and on land, are generally covered with a thick exoskeleton, and have a single pair of pincers."
        ),
        Animal(
            "Crocodile",
            R.drawable.crocodile,
            "Crocodiles (subfamily Crocodylinae) or true crocodiles are large semiaquatic reptiles that live throughout the tropics in Africa, Asia, the Americas and Australia."
        ),
        Animal(
            "Dino",
            R.drawable.dino,
            "Dinosaurs are a diverse group of reptiles of the clade Dinosauria. They first appeared during the Triassic period, between 243 and 233.23 million years ago, although the exact origin and timing of the evolution of dinosaurs is the subject of active research."
        ),
        Animal(
            "Dog",
            R.drawable.dog,
            "The domestic dog (Canis familiaris when considered a separate species or Canis lupus familiaris when considered a subspecies of the wolf) is a wolf-like canid that can be found distributed around the world."
        ),
        Animal(
            "Eagle",
            R.drawable.eagle,
            "Eagle is the common name for many large birds of prey of the family Accipitridae. Eagles belong to several groups of genera, some of which are closely related. Most of the 60 species of eagle are from Eurasia and Africa."
        ),
        Animal(
            "Fish",
            R.drawable.fish,
            "Fish are gill-bearing aquatic craniate animals that lack limbs with digits. They form a sister group to the tunicates, together forming the olfactores. Included in this definition are the living hagfish, lampreys, and cartilaginous and bony fish as well as various extinct related groups."
        ),
        Animal(
            "Fox",
            R.drawable.fox,
            "Foxes are small to medium-sized, omnivorous mammals belonging to several genera of the family Canidae. Foxes have a flattened skull, upright triangular ears, a pointed, slightly upturned snout, and a long bushy tail (or brush)."
        ),
        Animal(
            "Frog",
            R.drawable.frog,
            "A frog is any member of a diverse and largely carnivorous group of short-bodied, tailless amphibians composing the order Anura (literally without tail in Ancient Greek)."
        ),
        Animal(
            "Lion",
            R.drawable.lion,
            "The lion (Panthera leo) is a species in the family Felidae and a member of the genus Panthera. It has a muscular, deep-chested body, short, rounded head, round ears, and a hairy tuft at the end of its tail."
        ),
        Animal(
            "Mouse",
            R.drawable.mouse,
            "A mouse, plural mice, is a small rodent. Characteristically, mice are known to have a pointed snout, small rounded ears, a body-length scaly tail, and a high breeding rate."
        ),
        Animal(
            "Rabbit",
            R.drawable.rabbit,
            "Rabbits are small mammals in the family Leporidae (along with the hare) of the order Lagomorpha (along with the pika)."
        ),
        Animal(
            "Shark",
            R.drawable.shark,
            "Sharks are a group of elasmobranch fish characterized by a cartilaginous skeleton, five to seven gill slits on the sides of the head, and pectoral fins that are not fused to the head."
        ),
        Animal(
            "Snake",
            R.drawable.snake,
            "Snakes are elongated, legless, carnivorous reptiles of the suborder Serpentes. Like all other squamates, snakes are ectothermic, amniote vertebrates covered in overlapping scales."
        ),
        Animal(
            "Spider",
            R.drawable.spider,
            "Spiders (order Araneae) are air-breathing arthropods that have eight legs, chelicerae with fangs generally able to inject venom, and spinnerets that extrude silk. They are the largest order of arachnids and rank seventh in total species diversity among all orders of organisms."
        ),
        Animal(
            "Turtle",
            R.drawable.turtle,
            "Turtles are reptiles of the order Chelonia or Testudines. They are characterized by a special bony or cartilaginous shell developed from their ribs that acts as a shield."
        ),
        Animal(
            "Wolf",
            R.drawable.wolf,
            "The wolf also known as the gray wolf or grey wolf, is a large canine native to Eurasia and North America. More than thirty subspecies of Canis lupus have been recognized, and gray wolves, as colloquially understood, comprise non-domestic/feral subspecies."
        )
    )
}
