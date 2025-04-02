package com.example.artspaceapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.artspaceapp.ui.theme.ArtSpaceAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtSpaceApp()
                }
            }
        }
    }
}
 @Composable
fun ArtSpaceApp(modifier: Modifier = Modifier){
     var artImage by remember { mutableStateOf(1) }
     var artTitle by remember { mutableStateOf("Art work 1") }
     var artistName by remember { mutableStateOf("Artist 1") }
     Column(
         horizontalAlignment = Alignment.CenterHorizontally,
         verticalArrangement = Arrangement.Center
     ) {
         Column(
             modifier = Modifier.weight(1f),
             horizontalAlignment = Alignment.CenterHorizontally,
             verticalArrangement = Arrangement.Center
         ) {
             ArtSpaceImage(imageId = artImage)
         }
         Column(
             modifier = Modifier
                 .height(150.dp)
                 .padding(16.dp)
                 .shadow(6.dp, shape = RectangleShape)
                 .background(Color.LightGray),
             horizontalAlignment = Alignment.CenterHorizontally,
             verticalArrangement = Arrangement.Center

         ){
             ArtSpaceText(text = artTitle)
             Spacer(modifier = Modifier.height(15.dp))
             ArtSpaceText(text = artistName)

         }


         Spacer(modifier = Modifier.height(32.dp))
         Row(
             modifier = Modifier
                 .fillMaxWidth(),
             horizontalArrangement = Arrangement.SpaceEvenly
         ) {
             ArtSpaceButton(
                 text = "Previous",
                 modifier = Modifier.weight(1f),
                 onClick = {
                     when(artImage){
                         3 -> {
                             artImage = 1
                             artTitle = "ArtWork 1"
                             artistName = "Artist 1"
                         }
                         2 -> {
                             artImage = 3
                             artTitle = "ArtWork 3"
                             artistName = "Artist 3"
                         }
                          1-> {
                             artImage = 2
                             artTitle = "ArtWork 2"
                             artistName = "Artist 2"
                         }
                     }
                 }

             )
             ArtSpaceButton(
                 text = "Next",
                 modifier = Modifier.weight(1f),
                 onClick = {
                     when(artImage){
                         1 -> {
                             artImage = 2
                             artTitle = "ArtWork 2"
                             artistName = "Artist 2"
                         }
                         2 -> {
                             artImage = 3
                             artTitle = "ArtWork 3"
                             artistName = "Artist 3"
                         }
                         3 -> {
                             artImage = 1
                             artTitle = "ArtWork 1"
                             artistName = "Artist 1"
                         }
                     }
                 }
             )
         }
         Spacer(modifier = Modifier.height(32.dp))
}

}

@Composable
fun ArtSpaceImage(modifier: Modifier = Modifier, imageId: Int){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(50.dp)
            .shadow(6.dp, shape = RoundedCornerShape(16.dp))
            .clip(RoundedCornerShape(16.dp)),
        contentAlignment = Alignment.Center
    ) {
        val imageResource = when(imageId){
            1 -> R.drawable.picture_1
            2 -> R.drawable.picture_2
            3 -> R.drawable.picture_3
            else -> R.drawable.picture_1
        }
        Image(
            painter = painterResource(imageResource),
            contentDescription = "Art work image",
            modifier = Modifier
                .fillMaxSize(),
            contentScale = ContentScale.Crop

        )
    }


}

@Composable
fun ArtSpaceText(text: String, modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = text)
    }
}

@Composable
fun ArtSpaceButton(
    text: String, modifier: Modifier = Modifier, onClick: () -> Unit
) {

    Box(
        modifier = Modifier,
        contentAlignment = Alignment.BottomCenter

    ) {
        Button(
            modifier = Modifier
                .padding(horizontal = 16.dp),
            onClick = onClick) {
            Text(text = text, modifier = Modifier.padding(horizontal = 8.dp))
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ArtSpaceAppPreview(){
    ArtSpaceAppTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            ArtSpaceApp()
        }
    }
}


/*

That’s great to hear! Let’s move on to another project to help you practice and solidify your understanding of Jetpack Compose, state management, and UI design. I’ll give you a new project idea, along with some guidelines to help you structure your work.

New Project: Recipe Viewer App
App Description
Create a Recipe Viewer App that displays a list of recipes. Each recipe should have:

A name.

A short description.

An image.

A button to view more details (e.g., ingredients and instructions).

The app should allow users to:

Scroll through a list of recipes.

Tap a recipe to view its details.

Navigate back to the list from the details screen.

Guidelines
Here’s a step-by-step guide to help you structure the app. Try to implement it on your own, and if you get stuck, refer to the hints or ask for help.

Step 1: Set Up the Project
Create a new Jetpack Compose project in Android Studio.

Add any necessary dependencies (e.g., for images or navigation).

Step 2: Define the Data Model
Create a data class to represent a recipe:

kotlin
Copy
data class Recipe(
    val id: Int,
    val name: String,
    val description: String,
    val imageRes: Int, // Use resource IDs for images
    val ingredients: List<String>,
    val instructions: List<String>
)
Create a list of sample recipes in your ViewModel or directly in your composable:

kotlin
Copy
val recipes = listOf(
    Recipe(
        id = 1,
        name = "Pasta Carbonara",
        description = "Creamy Italian pasta dish.",
        imageRes = R.drawable.pasta_carbonara,
        ingredients = listOf("Spaghetti", "Eggs", "Parmesan", "Bacon"),
        instructions = listOf("Boil pasta", "Cook bacon", "Mix eggs and cheese", "Combine all")
    ),
    Recipe(
        id = 2,
        name = "Chicken Curry",
        description = "Spicy and flavorful curry.",
        imageRes = R.drawable.chicken_curry,
        ingredients = listOf("Chicken", "Curry Powder", "Coconut Milk", "Onions"),
        instructions = listOf("Cook chicken", "Sauté onions", "Add curry powder", "Simmer with coconut milk")
    )
    // Add more recipes
)
Step 3: Create the Recipe List Screen
Create a composable to display the list of recipes:

kotlin
Copy
@Composable
fun RecipeList(recipes: List<Recipe>, onRecipeClick: (Recipe) -> Unit) {
    LazyColumn {
        items(recipes) { recipe ->
            RecipeItem(recipe = recipe, onClick = { onRecipeClick(recipe) })
        }
    }
}
Create a composable for each recipe item:

kotlin
Copy
@Composable
fun RecipeItem(recipe: Recipe, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onClick() },
        elevation = 4.dp
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Image(
                painter = painterResource(recipe.imageRes),
                contentDescription = recipe.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = recipe.name, style = MaterialTheme.typography.headlineSmall)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = recipe.description, style = MaterialTheme.typography.bodyMedium)
        }
    }
}
Step 4: Create the Recipe Details Screen
Create a composable to display the details of a selected recipe:

kotlin
Copy
@Composable
fun RecipeDetails(recipe: Recipe, onBackClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Image(
            painter = painterResource(recipe.imageRes),
            contentDescription = recipe.name,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .clip(RoundedCornerShape(8.dp)),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = recipe.name, style = MaterialTheme.typography.headlineLarge)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Ingredients", style = MaterialTheme.typography.headlineSmall)
        recipe.ingredients.forEach { ingredient ->
            Text(text = "- $ingredient", style = MaterialTheme.typography.bodyMedium)
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Instructions", style = MaterialTheme.typography.headlineSmall)
        recipe.instructions.forEachIndexed { index, instruction ->
            Text(text = "${index + 1}. $instruction", style = MaterialTheme.typography.bodyMedium)
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = onBackClick) {
            Text(text = "Back to List")
        }
    }
}
Step 5: Add Navigation
Use NavController to navigate between the list and details screens:

kotlin
Copy
@Composable
fun RecipeApp() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "recipeList") {
        composable("recipeList") {
            RecipeList(recipes = recipes, onRecipeClick = { recipe ->
                navController.navigate("recipeDetails/${recipe.id}")
            })
        }
        composable("recipeDetails/{recipeId}") { backStackEntry ->
            val recipeId = backStackEntry.arguments?.getString("recipeId")?.toIntOrNull()
            val recipe = recipes.find { it.id == recipeId }
            if (recipe != null) {
                RecipeDetails(recipe = recipe, onBackClick = { navController.popBackStack() })
            }
        }
    }
}
Step 6: Test the App
Run the app and test the following:

Scroll through the list of recipes.

Tap a recipe to view its details.

Navigate back to the list from the details screen.

Key Concepts to Practice
State Management: Use mutableStateOf or ViewModel to manage state.

Navigation: Use NavController to navigate between screens.

Composable Functions: Break down the UI into reusable composables.

Lists: Use LazyColumn to display a scrollable list of items.

Data Modeling: Use data class to define structured data.

Stretch Goals
If you finish the basic app, try adding these features:

Search Bar: Allow users to search for recipes by name.

Favorites: Add a button to mark recipes as favorites and display them in a separate list.

Animations: Add animations when navigating between screens or displaying recipe details.

Let me know if you need help with any part of this project! 😊

 */