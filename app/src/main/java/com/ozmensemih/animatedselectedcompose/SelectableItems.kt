package com.ozmensemih.animatedselectedcompose


import androidx.compose.animation.core.*
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch


@Composable
fun SelectableItems(
    modifier: Modifier= Modifier,
    selected:Boolean,
    title:String,
    titleColor:Color =
        if (selected) MaterialTheme.colorScheme.primary
    else MaterialTheme.colorScheme.onSurface.copy(0.2f),
    titleSize :TextUnit = MaterialTheme.typography.headlineSmall.fontSize,
    titleWeight: FontWeight = FontWeight.Medium,
    subTitle:String?= null,
    subTitleColor: Color =
        if (selected) MaterialTheme.colorScheme.onSurface
    else MaterialTheme.colorScheme.onSurface.copy(0.2f),
    borderWidth : Dp = 1.dp,
    borderShapes: Shape = RoundedCornerShape(10.dp),
    borderColor :Color =
        if (selected) MaterialTheme.colorScheme.primary
        else MaterialTheme.colorScheme.onSurface.copy(0.2f),
    icon: ImageVector = Icons.Default.CheckCircle,
    iconColor:Color =
        if (selected) Color.Green
        else MaterialTheme.colorScheme.onSurface.copy(0.2f),
    onclick:()->Unit

){

    val scaleA = remember { Animatable(initialValue = 1f) }
    val scaleB = remember { Animatable(initialValue = 1f) }
    LaunchedEffect(key1 = selected){
        if(selected){
            launch {
                scaleA.animateTo(
                    targetValue = 0.3f,
                    animationSpec = tween(
                        durationMillis = 50
                    )
                )
                scaleB.animateTo(
                    targetValue = 1f,
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioLowBouncy,
                        stiffness = Spring.StiffnessLow
                    )
                )
            }

            launch {
                scaleA.animateTo(
                    targetValue = 0.9f,
                    animationSpec = tween(
                        durationMillis = 50
                    )
                )
                scaleB.animateTo(
                    targetValue = 1f,
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioLowBouncy,
                        stiffness = Spring.StiffnessLow
                    )
                )
            }
        }
    }

    Column(modifier = modifier
        .border(width = borderWidth, color = borderColor, shape = borderShapes)
        .scale(scaleB.value)
        .clip(borderShapes)
        .clickable {
            onclick()
        }) {
        Row (modifier = modifier.padding(start = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(modifier=modifier.weight(8f) ,
                text = title,
                style = TextStyle(
                    color = titleColor,
                    fontSize = titleSize,
                    fontWeight = titleWeight
                ),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            IconButton(
                modifier = Modifier.weight(2F).
                scale(scaleA.value),
                onClick = onclick
            ) {
                Icon(imageVector =icon,contentDescription = null,
                    tint = iconColor)
            }
        }
        if(subTitle!= null){
            Text(modifier = Modifier
                .padding(horizontal = 12.dp)
                .padding(bottom = 12.dp),
                text =subTitle,
                style = TextStyle(
                    color = subTitleColor
                ),
                maxLines = 3,
                overflow = TextOverflow.Ellipsis)
        }
    }

}