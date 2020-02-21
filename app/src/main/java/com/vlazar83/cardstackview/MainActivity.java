package com.vlazar83.cardstackview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.yuyakaido.android.cardstackview.CardStackLayoutManager;
import com.yuyakaido.android.cardstackview.CardStackListener;
import com.yuyakaido.android.cardstackview.CardStackView;
import com.yuyakaido.android.cardstackview.Direction;
import com.yuyakaido.android.cardstackview.StackFrom;
import com.yuyakaido.android.cardstackview.SwipeableMethod;
import android.view.animation.LinearInterpolator;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements CardStackListener {

    private CardStackLayoutManager manager;
    private CardStackView cardStackView;
    private CardStackAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager = new CardStackLayoutManager(this, this);
        cardStackView = (CardStackView) findViewById(R.id.card_stack_view);
        adapter = new CardStackAdapter();



        adapter.setSpots(createSpots());


        setupCardStackView();

    }

    @Override
    public void onCardDragging(Direction direction, float ratio) {

    }

    @Override
    public void onCardSwiped(Direction direction) {

    }

    @Override
    public void onCardRewound() {

    }

    @Override
    public void onCardCanceled() {

    }

    @Override
    public void onCardAppeared(View view, int position) {

    }

    @Override
    public void onCardDisappeared(View view, int position) {

    }

    private void setupCardStackView(){
        initialize();

    }

    private void initialize(){
        manager.setStackFrom(StackFrom.None);
        manager.setVisibleCount(3);
        manager.setTranslationInterval(8.0f);
        manager.setScaleInterval(0.95f);
        manager.setSwipeThreshold(0.3f);
        manager.setMaxDegree(20.0f);
        manager.setDirections(Direction.HORIZONTAL);
        manager.setCanScrollHorizontal(true);
        manager.setCanScrollVertical(true);
        manager.setSwipeableMethod(SwipeableMethod.AutomaticAndManual);
        manager.setOverlayInterpolator(new LinearInterpolator());

        cardStackView.setLayoutManager((RecyclerView.LayoutManager) manager);
        cardStackView.setAdapter(adapter);
        cardStackView.getItemAnimator();
    }

    private List<Spot> createSpots(){
        List<Spot> spots = new ArrayList<Spot>();
        spots.add(new Spot(1, "Yasaka Shrine", "Kyoto", "https://source.unsplash.com/Xq1ntWruZQI/600x800"));
        spots.add(new Spot(2, "Yasaka Shrine", "Kyoto", "https://source.unsplash.com/NYyCqdBOKwc/600x800"));
        spots.add(new Spot(3, "Yasaka Shrine", "Kyoto", "https://source.unsplash.com/buF62ewDLcQ/600x800"));
        spots.add(new Spot(4, "Yasaka Shrine", "Kyoto", "https://source.unsplash.com/THozNzxEP3g/600x800"));
        spots.add(new Spot(5, "Yasaka Shrine", "Kyoto", "https://source.unsplash.com/PeFk7fzxTdk/600x800"));
        spots.add(new Spot(6, "Yasaka Shrine", "Kyoto", "https://source.unsplash.com/LrMWHKqilUw/600x800"));

        return spots;

    }


}
