package com.mark.kotlincourse.presentation.coinlist

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.navArgument
import com.mark.kotlincourse.domain.model.Coin
import com.mark.kotlincourse.presentation.Screen
import com.mark.kotlincourse.presentation.coinlist.components.coinListItem

@Composable
fun CoinListScreen(
    navController: NavController,
    viewModel: CoinListViewModel= hiltViewModel()



) {
    val state =viewModel.state.value
    Box(modifier = Modifier.fillMaxSize()){
        LazyColumn(modifier = Modifier.fillMaxSize()){
            items(state.coins){ coin ->
                coinListItem(coin = coin, onItemClick ={

                    navController.navigate(Screen.CoinDetailScreen.route + "/${coin.id}")

                } )

            }
        }








    }
    
    
    
    if (state.error.isBlank()){
        Text(text = state.error.toString(),
        color= Color.Red,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)


        )
    }
    if (state.isloading){
CircularProgressIndicator()

    }
    
    
    
    
}