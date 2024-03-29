package com.example.jetpackcomposecomponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
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
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
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
            CustomDivider()
            NewChip()
            CustomDivider()
            NewButton()
            CustomDivider()
            NewBadge()
            CustomDivider()
            NewChecks()
        }
    }
}

@Composable
fun NewChecks() {
    Row(verticalAlignment = Alignment.CenterVertically) {
        var isCheckboxChecked by remember { mutableStateOf(false) }
        Checkbox(checked = isCheckboxChecked, onCheckedChange = { isCheckboxChecked = it })
        Text(text = "Terminos y condiciones")

        Spacer(modifier = Modifier.weight(1f))

        var isSwitchChecked by remember { mutableStateOf(false) }
        Text(text = "Anuncios")
        Switch(checked = isSwitchChecked, onCheckedChange = { isSwitchChecked = it })
    }
}

@Composable
fun NewBadge() {
    Row(horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalAlignment = Alignment.CenterVertically) {
        BadgedBox(badge = {
            Badge {
                val badgeNumber = "5"
                Text(
                    text = badgeNumber,
                    modifier = Modifier.semantics { contentDescription = "$badgeNumber items"})
            }
        }) {
            Icon(imageVector = Icons.Filled.ShoppingCart, contentDescription = "Cart")
        }

        OutlinedButton(onClick = { }) {
            Text(text = "View Cart")
            Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
            BadgedBox(badge = {
                Badge {
                    val badgeNumber = "5"
                    Text(
                        text = badgeNumber,
                        modifier = Modifier.semantics { contentDescription = "$badgeNumber items"})
                }
            }) {
                Icon(imageVector = Icons.Filled.ShoppingCart, contentDescription = "Cart")
            }
        }
    }
}

@Composable
fun NewButton() {
    Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
        Button(onClick = { }) { Text(text = "Finish") }
        Button(onClick = { }) {
            //Nota: si quieres cambiar el orden del icono solo es mover el orden de las propiedades
            Text(text = "Send")
            Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
            Icon(imageVector = Icons.Filled.Close, contentDescription = null,
                modifier = Modifier.size(ButtonDefaults.IconSize))
        }
        OutlinedButton(onClick = { }) { Text(text = "Back") }
        TextButton(onClick = { }) { Text(text = "LogOut") }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun NewChip() {
    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        Chip(onClick = {}) { Text(text = "Etiqueta") }
        Chip(onClick = {}, leadingIcon = {
            Icon(imageVector = Icons.Filled.Notifications, contentDescription = "Delete Tag",
                modifier = Modifier.padding(start = 4.dp))
        }) {
            Text(text = "Etiqueta")
            Icon(imageVector = Icons.Filled.Close, contentDescription = "Delete Tag",
                modifier = Modifier.padding(start = 16.dp))
        }
        Chip(onClick = {}, border = ChipDefaults.outlinedBorder,
            colors = ChipDefaults.outlinedChipColors()) { Text(text = "Etiqueta") }
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
