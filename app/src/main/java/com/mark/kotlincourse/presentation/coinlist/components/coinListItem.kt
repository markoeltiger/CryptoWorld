package com.mark.kotlincourse.presentation.coinlist.components

import android.widget.AdapterView
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.mark.kotlincourse.domain.model.Coin

@Composable
fun coinListItem(
    coin: Coin,
    onItemClick:(Coin)->Unit


) {
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemClick(coin) }
            .padding(20.dp),
        horizontalArrangement = Arrangement.SpaceBetween

        )  {
         Text(text = "${coin.rank}. ${coin.name} (${coin.symbol})",
         overflow = TextOverflow.Ellipsis,
             style = MaterialTheme.typography.body1
         )
        Text(
            text = if (coin.is_active)"active" else "inactive",
            color=if (coin.is_active) Color.Green else Color.Red,
            fontStyle = FontStyle.Italic,
            textAlign = TextAlign.End,
            style = MaterialTheme.typography.body1,
            modifier = Modifier.align(CenterVertically)

        )
             }





    }
