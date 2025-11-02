package com.travenor.travellingapp.presentation.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.travenor.travellingapp.R
import com.travenor.travellingapp.presentation.theme.Gray
import com.travenor.travellingapp.presentation.theme.SFUI
import com.travenor.travellingapp.presentation.theme.SubTextColor
import com.travenor.travellingapp.presentation.theme.TextColor

@Composable
fun DefaultTextField(label: String, passwordType: Boolean, onValueChange: (String) -> Unit) {
    var textFieldValue by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    var isFocused by remember { mutableStateOf(false) }

    val emailPattern = Regex("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")

    Column(modifier = Modifier.fillMaxWidth()) {
        OutlinedTextField(
            value = textFieldValue,
            onValueChange = {
                textFieldValue = it
                onValueChange(it)
            },
            modifier = Modifier
                .height(60.dp)
                .fillMaxWidth()
                .onFocusChanged { focusState -> isFocused = focusState.isFocused }
                .clip(RoundedCornerShape(14.dp))
                .background(Gray, RoundedCornerShape(14.dp)),
            label = {
                if (!isFocused && textFieldValue.isEmpty()) {
                    Row(
                        modifier = Modifier.fillMaxHeight(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            label,
                            fontSize = 16.sp,
                            lineHeight = 20.sp,
                            fontWeight = FontWeight.Normal,
                            modifier = Modifier
                                .fillMaxHeight()
                                .padding(bottom = 4.dp),
                            fontFamily = SFUI,
                            textAlign = TextAlign.Center
                        )
                    }
                }
            },
            trailingIcon = {
                if (passwordType) {
                    if (textFieldValue.isNotEmpty()) {
                        Row(
                            modifier = Modifier.fillMaxHeight(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            IconButton(
                                onClick = { passwordVisible = !passwordVisible },
                                modifier = Modifier
                                    .width(26.dp)
                                    .height(20.dp)
                                    .padding(bottom = 4.dp)
                            ) {
                                Icon(
                                    painter = if (passwordVisible)
                                        painterResource(id = R.drawable.eye_opened)
                                    else
                                        painterResource(id = R.drawable.eye_closed),
                                    contentDescription = null,
                                    tint = SubTextColor
                                )
                            }
                        }
                    }
                }
            }, colors = OutlinedTextFieldDefaults.colors(
                unfocusedContainerColor = Gray,
                focusedContainerColor = Gray,
                unfocusedTextColor = SubTextColor,
                focusedTextColor = TextColor,
                focusedBorderColor = Color.Transparent,
                unfocusedBorderColor = Color.Transparent,
                cursorColor = TextColor,
                unfocusedLabelColor = SubTextColor,
                focusedLabelColor = TextColor
            ),
            visualTransformation = if (passwordType && !passwordVisible)
                PasswordVisualTransformation()
            else
                VisualTransformation.None
        )

        if (passwordType && textFieldValue.length < 8 && isFocused) {
            Spacer(Modifier.height(16.dp))

            Text(
                "Password must be 8 character",
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal,
                fontFamily = SFUI,
                lineHeight = 16.sp,
                color = SubTextColor
            )
        }
    }


}