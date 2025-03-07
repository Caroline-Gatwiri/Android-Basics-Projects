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

@Composable
fun TipTimeLayout() {
    var amountInput by remember { mutableStateOf("") }
    var tipInput by remember { mutableStateOf("") }
    val amount = amountInput.toDoubleOrNull() ?: 0.0
    val tipPercent = tipInput.toDoubleOrNull() ?: 0.0
    var roundUp by remember {
        mutableStateOf(false)
    }

    val tip = calculateTip(amount, tipPercent, roundUp)
    Column(
        modifier = Modifier
            .padding(40.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(R.string.calculate_tip),
            modifier = Modifier
                .padding(bottom = 16.dp)
                .align(alignment = Alignment.Start)
        )
        EditNumberField(
            label = R.string.bill_amount,
            value = amountInput,
            onValueChange = { amountInput = it },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Next
            ),
            leadingIcon = R.drawable.money,
            modifier = Modifier
                .padding(bottom = 32.dp)
                .fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(15.dp))
        EditNumberField(
            label = R.string.how_was_the_service,
            value = tipInput,
            onValueChange = { tipInput = it },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done
            ),
            leadingIcon = R.drawable.percent,
            modifier = Modifier
                .padding(bottom = 32.dp)
                .fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(15.dp))
        RoundTheTipRow(roundUp = roundUp, onRoundUpChanged ={roundUp = it} )
        Spacer(modifier = Modifier.height(15.dp))
        Text(
            text = stringResource(R.string.tip_amount, tip),
            style = MaterialTheme.typography.headlineSmall
        )
        Spacer(modifier = Modifier.height(150.dp))
    }
}

@Composable
fun EditNumberField(
    value: String,
    onValueChange: (String) -> Unit,
    @StringRes label: Int,
    @DrawableRes leadingIcon: Int,
    keyboardOptions: KeyboardOptions,
    modifier: Modifier = Modifier
) {

    TextField(
        value = value,
        leadingIcon = { Icon(painter = painterResource(id = leadingIcon), contentDescription =null
        )},
        onValueChange = onValueChange,
        label = { Text(stringResource(label)) },
        singleLine = true,
        keyboardOptions = keyboardOptions
    )
}

@Composable
fun RoundTheTipRow(
    roundUp :Boolean,
    onRoundUpChanged : (Boolean) -> Unit,
    modifier: Modifier = Modifier
){
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .size(48.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        Text(text = stringResource(R.string.round_up_tip))
        Switch(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.End),
            checked = roundUp,
            onCheckedChange = onRoundUpChanged
        )
    }

}



 */