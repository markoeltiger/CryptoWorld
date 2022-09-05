package com.mark.kotlincourse.presentation.coindetail.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import com.mark.kotlincourse.data.remote.dto.Team
import java.lang.reflect.Modifier

@Composable
fun TeamListItem(
team:Team,
modifier:androidx.compose.ui.Modifier=androidx.compose.ui.Modifier




)


{
Column(
    modifier = modifier,
    verticalArrangement = Arrangement.Center

) {
    Text(text = team.name,
style = MaterialTheme.typography.h4
        )
    Spacer(modifier = modifier.height(4.dp))
    Text(text = team.position,
        style = MaterialTheme.typography.body2,
        fontStyle = FontStyle.Italic
    )

}    
}