package com.travenor.travellingapp.presentation.screens.onboardingScreen

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavHostController
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PaintingStyle.Companion.Stroke
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.travenor.travellingapp.R
import com.travenor.travellingapp.data.utils.Constants
import com.travenor.travellingapp.data.utils.Destinations
import com.travenor.travellingapp.presentation.composable.DefaultButton
import com.travenor.travellingapp.presentation.theme.Action
import com.travenor.travellingapp.presentation.theme.BG
import com.travenor.travellingapp.presentation.theme.Geometr
import com.travenor.travellingapp.presentation.theme.GillSansMT
import com.travenor.travellingapp.presentation.theme.MainWhite
import com.travenor.travellingapp.presentation.theme.SubTextColor
import com.travenor.travellingapp.presentation.theme.TextColor
import com.travenor.travellingapp.presentation.theme.Typography
import kotlinx.coroutines.launch
import kotlin.io.path.Path

@Composable
fun OnboardingScreen(
    navController: NavHostController = rememberNavController(),
    viewModel: OnboardingViewModel = hiltViewModel()
) {
    val scope = rememberCoroutineScope()

    val savedPage by viewModel.page.collectAsState()
    val pagerState = rememberPagerState(
        initialPage = 0,
        pageCount = { Constants.onboardingPages.size }
    )

    LaunchedEffect(savedPage) {
        pagerState.scrollToPage(savedPage)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MainWhite)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier, userScrollEnabled = false
        ) { page ->
            val item = Constants.onboardingPages[page]

            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(modifier = Modifier.fillMaxWidth()) {
                    Image(
                        painter = painterResource(id = item.image),
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(bottomStart = 30.dp, bottomEnd = 30.dp)),
                        contentScale = ContentScale.Crop
                    )
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 60.dp, end = 20.dp),
                        horizontalArrangement = Arrangement.End
                    ) {
                        Text(
                            "Skip",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Normal,
                            fontFamily = GillSansMT,
                            color = BG, modifier = Modifier.clickable {
                                scope.launch {
                                    viewModel.completeOnboarding()
                                    navController.navigate(Destinations.SignIn) {
                                        popUpTo(navController.graph.startDestinationId) {
                                            inclusive = true
                                        }
                                    }
                                }
                            }
                        )
                    }
                }
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 20.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    val title = item.title
                    val words = title.split(" ")

                    val annotatedTitle = buildAnnotatedString {
                        if (words.size > 1) {
                            append(words.dropLast(1).joinToString(" ") + " ")
                        }
                        withStyle(style = SpanStyle(color = Action)) {
                            append(words.last())
                        }
                    }

//                    var lastWordWidth by remember { mutableStateOf(0f) }
//                    var lastWordOffsetX by remember { mutableStateOf(0f) }


                    Spacer(modifier = Modifier.height(40.dp))

                    Column(modifier = Modifier.fillMaxWidth()) {
                        Text(
                            text = annotatedTitle,
                            style = Typography.titleLarge,
                            modifier = Modifier.fillMaxWidth(),
//                            onTextLayout = { layout ->
//                                val lastWord = words.lastOrNull() ?: return@Text
//                                val start = title.lastIndexOf(lastWord)
//                                val end = start + lastWord.length
//
//                                val startBox = layout.getBoundingBox(start)
//                                val endBox = layout.getBoundingBox(end - 1)
//
//                                val layoutLineLeft = layout.getLineLeft(layout.getLineForOffset(start))
//                                lastWordOffsetX = startBox.left - layoutLineLeft
//                                lastWordWidth = endBox.right - startBox.left
//                            }
                        )

//                        if (lastWordWidth > 0f) {
//                            Canvas(
//                                modifier = Modifier
//                                    .offset(x = with(LocalDensity.current) { lastWordOffsetX.toDp() })
//                                    .width(with(LocalDensity.current) { lastWordWidth.toDp() })
//                                    .height(12.dp)
//                            ) {
//                                val startX = 0f
//                                val endX = size.width
//                                val midX = (startX + endX) / 2f
//                                val baseY = size.height * 0.8f
//
//                                val path = Path().apply {
//                                    moveTo(startX, baseY)
//                                    quadraticBezierTo(
//                                        midX, baseY - size.height / 2.5f,
//                                        endX, baseY
//                                    )
//                                }
//
//                                drawPath(
//                                    path = path,
//                                    brush = Brush.horizontalGradient(
//                                        colors = listOf(Color.Transparent, Action, Color.Transparent),
//                                        startX = startX,
//                                        endX = endX
//                                    ),
//                                    style = Stroke(
//                                        width = 4.dp.toPx(),
//                                        cap = StrokeCap.Round,
//                                        join = StrokeJoin.Round
//                                    )
//                                )
//                            }
//                        }
                    }

                    Spacer(modifier = Modifier.height(8.dp))
                    Text(text = item.description, style = Typography.bodyMedium.copy(fontFamily = GillSansMT))
                    Spacer(modifier = Modifier.height(22.dp))
                    Icon(
                        painterResource(item.indicator),
                        contentDescription = null,
                        tint = Color.Unspecified
                    )
                }
            }
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        ) {
            Spacer(modifier = Modifier.height(40.dp))

            DefaultButton(if (pagerState.currentPage < 1) "Get Started" else "Next") {
                scope.launch {
                    val nextPage = pagerState.currentPage + 1
                    if (nextPage < Constants.onboardingPages.size) {
                        pagerState.animateScrollToPage(nextPage)
                        viewModel.saveCurrentPage(nextPage)
                    } else {
                        viewModel.completeOnboarding()
                        navController.navigate(Destinations.SignIn) {
                            popUpTo(navController.graph.startDestinationId) { inclusive = true }
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(40.dp))

        }
    }
}
