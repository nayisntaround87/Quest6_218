package com.example.myarsitekturmvvm.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myarsitekturmvvm.model.Siswa
import kotlinx.serialization.builtins.PairSerializer

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TampilSiswa(
    //edit 1 : parameter statusUiSiswa
    statusUiSiswa: Siswa,
    onBackButtonClicked:()-> Unit
){
    //edit 2 : Items pair
    val items = listOf(
        Pair(stringResource("Nama Lengkap"), statusUiSiswa.nama),
        Pair(stringResource(id = "Jenis Kelamin"), statusUiSiswa.gender),
        Pair(stringResource("Alamat"), statusUiSiswa.alamat)
    )
    Scaffold(modifier = Modifier,
        {
            TopAppBar(
                title = { Text(stringResource(id = "Data Siswa"), color = Color.White) },
                colors = TopAppBarDefaults.mediumTopAppBarColors(colorResource(id = R.color.purple_500)),

            )
        }) { isiRuang ->
        Column(
            modifier = Modifier.padding(isiRuang),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier.padding(dimensionResource(16dp)),
                verticalArrangement = Arrangement.spacedBy(dimensionResource(10dp))
            ) {
                items.forEach { item ->
                    Column {
                        Text(item.first.uppercase(), fontSize = 16.dp)
                        Text(text = item.second, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                    }
                    Divider(thickness = dimensionResource(1dp))
                }
                Spacer(modifier = Modifier.height(dimensionResource(10dp)))
                Button(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = onBackButtonClicked
                ) {
                    Text(stringResource("Back"))
                }
            }
        }
    }
}