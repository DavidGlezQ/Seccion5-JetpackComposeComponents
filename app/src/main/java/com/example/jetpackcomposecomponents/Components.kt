package com.example.jetpackcomposecomponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true, showSystemUi = true, locale = "en")
@Composable
private fun ComponentsPreview() {
    //NewTextView()
    Components()
}

@Composable
fun Components() {
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp)) {
        Column(modifier = Modifier.padding(8.dp)) {
            NewTextView()
            CustomDivider()
            NewTextField()
            NewTextFieldOutLine()
            CustomDivider()
            NewImageView()
        }
    }
}

@Composable
fun NewImageView() {
    Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) { //Separacion estre cada hijo
        Image(painter = painterResource(id = R.drawable.img_eva), contentDescription = "Eva",
            modifier = Modifier
                .size(80.dp)
                .clip(CircleShape))

        Image(painter = painterResource(id = R.drawable.img_eva), contentDescription = "Eva",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(80.dp)
                .aspectRatio(4f / 3f))

        Image(painter = painterResource(id = R.drawable.img_eva), contentDescription = "Eva",
            modifier = Modifier
                .size(80.dp)
                .blur(radius = 8.dp, edgeTreatment = BlurredEdgeTreatment.Unbounded))


    }
    Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
        Image(painter = painterResource(id = R.drawable.img_eva), contentDescription = "Eva",
            modifier = Modifier
                .size(80.dp)
                .blur(
                    radius = 8.dp, edgeTreatment = BlurredEdgeTreatment(
                        CircleShape
                    )
                ))

        Image(painter = painterResource(id = R.drawable.img_eva), contentDescription = "Eva",
            modifier = Modifier
                .size(80.dp)
                .blur(
                    radius = 8.dp, edgeTreatment = BlurredEdgeTreatment(
                        RoundedCornerShape(8.dp)
                    )
                ))
    }
}

@Composable
fun NewTextFieldOutLine() {
    var textValue by remember { mutableStateOf("") }
    OutlinedTextField(value = textValue, onValueChange = { textValue = it },
        label = { Text(text = stringResource(id = R.string.lifecycle))},
        singleLine = true, modifier = Modifier.fillMaxWidth())

    var passwordValue by remember { mutableStateOf("") }
    OutlinedTextField(value = passwordValue, onValueChange = { passwordValue = it },
        label = { Text(text = "Password")}, visualTransformation = PasswordVisualTransformation(),
        trailingIcon = {
            if (passwordValue.isNotEmpty()) {
                Icon(imageVector = Icons.Filled.Clear, contentDescription = "Clear",
                    modifier = Modifier.clickable { passwordValue = "" })
            }
        },
        modifier = Modifier.fillMaxWidth())
}

@Composable
fun NewTextField() {
    var textValue by remember { mutableStateOf("Hi") }
    TextField(value = textValue, onValueChange = {
        textValue = it },
        label = { Text(text = "Type your dream...")}, modifier = Modifier.fillMaxWidth())
}

@Composable
fun NewTextView() {
    Column {
        Text(text = "Jetpack Compose", color = Color.DarkGray, fontSize = 28.sp,
            fontStyle = FontStyle.Italic, fontWeight = FontWeight.Bold,
            style = TextStyle(shadow = Shadow(color = Color.Magenta,
                offset = Offset( 2f, 2f), blurRadius = 4f)))
        
        Text(text = "The best Jetpack course in the world wide, I'm learning JetpackCompose!",
            style = MaterialTheme.typography.body1,
            maxLines = 2, overflow = TextOverflow.Ellipsis)

        Text(text = buildAnnotatedString {
            withStyle(style = SpanStyle(fontWeight = FontWeight.ExtraBold)) { append("Batman") }
            append(", Bruce Wayne")
        })

        Text(text = "Let's go to the next one.",
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.overline)
    }
}

@Composable
fun CustomDivider() {
    Spacer(modifier = Modifier.height(8.dp))
    Divider(modifier = Modifier.fillMaxWidth())
    Spacer(modifier = Modifier.height(16.dp))
}
