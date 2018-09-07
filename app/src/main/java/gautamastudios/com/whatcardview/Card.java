package gautamastudios.com.whatcardview;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Card extends RelativeLayout {

    private final static int NO_RULE = -1, PARENT_LAYOUT = 0, OUTER_BORDER = 1, POPUP_TAB = 2,
            CONTENT_CONTAINER = 3, ITEM_INDEX_BOX = 4, NAME_TEXT_VIEW = 5, PROGRESS_TEXT_VIEW = 6,
            DIVIDER_LINE = 7, DESCRIPTION_TEXT_VIEW = 8, BUTTON_CONTAINER = 9, BUTTON_IMAGE_VIEW = 10,
            BUTTON_TEXT_VIEW = 11;
    private int cardHeight, cardWidth;

    public Card(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        cardHeight = 180;//TODO Attrs
        cardWidth = 930;

        //TODO change to textview
        TextView popupTab = new TextView(context, attrs);
        popupTab.setId(View.generateViewId());
        popupTab.setBackground(generateDrawable(POPUP_TAB));
        popupTab.setLayoutParams(generateParams(POPUP_TAB, NO_RULE, NO_RULE));
        popupTab.setText("Current Module"); //TODO Set attrs or public method
        popupTab.setTextSize(TypedValue.COMPLEX_UNIT_PX, 15); //TODO Set attrs or public method
        popupTab.setTextColor(Color.WHITE); //TODO Set attrs or public method
        popupTab.setTypeface(Typeface.create("rubik_normal", Typeface.BOLD_ITALIC));//TODO SET FONT
        popupTab.setTextAlignment(TEXT_ALIGNMENT_CENTER);
        popupTab.setGravity(Gravity.CENTER);

        //TODO Drop shadow
        View outerBorder = new View(context, attrs);
        outerBorder.setId(View.generateViewId());
        outerBorder.setBackground(generateDrawable(OUTER_BORDER));
        outerBorder.setLayoutParams(generateParams(OUTER_BORDER, popupTab.getId(), NO_RULE));


        RelativeLayout contentContainer = new RelativeLayout(context, attrs);
        contentContainer.setId(View.generateViewId());
        contentContainer.setLayoutParams(generateParams(CONTENT_CONTAINER, popupTab.getId(), NO_RULE));// TODO Width and height need to be compensated to be a inner box
        //Item Index Box
        TextView itemIndexBox = new TextView(context, attrs);
        itemIndexBox.setId(View.generateViewId());
        itemIndexBox.setLayoutParams(generateParams(ITEM_INDEX_BOX, NO_RULE, NO_RULE));
        itemIndexBox.setBackground(generateDrawable(ITEM_INDEX_BOX));
        itemIndexBox.setText("0"); //TODO Set attrs or public method
        itemIndexBox.setTextSize(TypedValue.COMPLEX_UNIT_PX, 22); //TODO Set attrs or public method
        itemIndexBox.setTextColor(Color.WHITE); //TODO Set attrs or public method
        itemIndexBox.setTypeface(Typeface.create("rubik_normal", Typeface.BOLD));//TODO SET FONT
        itemIndexBox.setTextAlignment(TEXT_ALIGNMENT_CENTER);
        itemIndexBox.setGravity(Gravity.CENTER);
        //Name Text View
        TextView nameTextView = new TextView(context, attrs);
        nameTextView.setId(View.generateViewId());
        nameTextView.setLayoutParams(generateParams(NAME_TEXT_VIEW, itemIndexBox.getId(), NO_RULE));
        nameTextView.setText("How Children Learn to Read"); //TODO Set attrs or public method
        nameTextView.setTextSize(TypedValue.COMPLEX_UNIT_PX, 22); //TODO Set attrs or public method
        nameTextView.setTextColor(Color.BLACK); //TODO Set attrs or public method
        nameTextView.setTypeface(Typeface.create("rubik_normal", Typeface.BOLD));//TODO SET FONT
        nameTextView.setTextAlignment(TEXT_ALIGNMENT_CENTER);
        nameTextView.setGravity(Gravity.CENTER);
        //Progress Text View
        TextView progressTextView = new TextView(context, attrs);
        progressTextView.setId(View.generateViewId());
        progressTextView.setLayoutParams(generateParams(PROGRESS_TEXT_VIEW, nameTextView.getId(), NO_RULE));
        progressTextView.setText("1/6 Units complete"); //TODO Set attrs or public method
        progressTextView.setTextSize(TypedValue.COMPLEX_UNIT_PX, 15); //TODO Set attrs or public method
        progressTextView.setTextColor(Color.BLUE); //TODO Set attrs or public method (MODULE THEME COLOR)
        progressTextView.setTypeface(Typeface.create("rubik_normal", Typeface.NORMAL));//TODO SET FONT
        progressTextView.setTextAlignment(TEXT_ALIGNMENT_CENTER);
        progressTextView.setGravity(Gravity.CENTER);
        //Divider Line
        View dividerLine = new View(context, attrs);
        dividerLine.setId(View.generateViewId());
        dividerLine.setLayoutParams(generateParams(DIVIDER_LINE, progressTextView.getId(), NO_RULE));
        dividerLine.setBackgroundColor(Color.LTGRAY); //TODO Set color attrs #CCCCCC;
        //Description Text View
        TextView descriptionTextView = new TextView(context, attrs);
        descriptionTextView.setId(View.generateViewId());
        descriptionTextView.setLayoutParams(generateParams(DESCRIPTION_TEXT_VIEW, dividerLine.getId(), NO_RULE));
        descriptionTextView.setText("Introduction to course; processes of learning to read; emergent literacy; formal reading instruction; enabling conditions; the role of exposure; poverty and reading"); //TODO Set attrs or public method
        descriptionTextView.setTextSize(TypedValue.COMPLEX_UNIT_PX, 18); //TODO Set attrs or public method
        descriptionTextView.setTextColor(Color.DKGRAY); //TODO Set attrs or public method (#4A4A4A)
        descriptionTextView.setTypeface(Typeface.create("rubik_normal", Typeface.NORMAL));//TODO SET FONT
        descriptionTextView.setTextAlignment(TEXT_ALIGNMENT_TEXT_START);
        descriptionTextView.setGravity(Gravity.START);

        contentContainer.addView(itemIndexBox);
        contentContainer.addView(nameTextView);
        contentContainer.addView(progressTextView);
        contentContainer.addView(dividerLine);
        contentContainer.addView(descriptionTextView);

        //Button Container
        LinearLayout buttonContainer = new LinearLayout(context, attrs);
        buttonContainer.setId(View.generateViewId());
        buttonContainer.setLayoutParams(generateParams(BUTTON_CONTAINER, outerBorder.getId(), contentContainer.getId()));
        buttonContainer.setBackground(generateDrawable(BUTTON_CONTAINER));
        buttonContainer.setOrientation(LinearLayout.VERTICAL);
        //Button Image View
        ImageView buttonImageView = new ImageView(context, attrs);
        buttonImageView.setLayoutParams(generateParams(BUTTON_IMAGE_VIEW, NO_RULE, NO_RULE));
        buttonImageView.setScaleType(ImageView.ScaleType.CENTER);
        buttonImageView.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_android_black_24dp));
        //Button Text View
        TextView buttonTextView = new TextView(context, attrs);
        buttonTextView.setLayoutParams(generateParams(BUTTON_TEXT_VIEW, dividerLine.getId(), NO_RULE));
        buttonTextView.setText("Resume Module"); //TODO Set attrs or public method
        buttonTextView.setTextSize(TypedValue.COMPLEX_UNIT_PX, 16); //TODO Set attrs or public method
        buttonTextView.setTextColor(Color.WHITE); //TODO Set attrs or public method
        buttonTextView.setTypeface(Typeface.create("rubik_normal", Typeface.BOLD));//TODO SET FONT
        buttonTextView.setTextAlignment(TEXT_ALIGNMENT_CENTER);
        buttonTextView.setGravity(Gravity.CENTER);

        buttonContainer.addView(buttonImageView);
        buttonContainer.addView(buttonTextView);

        this.setLayoutParams(generateParams(PARENT_LAYOUT, NO_RULE, NO_RULE));

        this.addView(popupTab);
        this.addView(outerBorder);
        this.addView(contentContainer);
        this.addView(buttonContainer);
    }

    private ViewGroup.LayoutParams generateParams(int layoutType, int viewIdForRule1, int viewIdForRule2) {
        switch (layoutType) {
            case PARENT_LAYOUT:
                return new ConstraintLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            case OUTER_BORDER:
                RelativeLayout.LayoutParams outerBorder = new RelativeLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
                outerBorder.height = dpToPx(cardHeight);
                outerBorder.width = dpToPx(cardWidth);
                outerBorder.addRule(BELOW, viewIdForRule1);
                return outerBorder;
            case POPUP_TAB:
                RelativeLayout.LayoutParams popupTab = new RelativeLayout.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                popupTab.height = dpToPx(31);
                popupTab.width = dpToPx(151);
                popupTab.leftMargin = 48;
                return popupTab;
            case CONTENT_CONTAINER:
                RelativeLayout.LayoutParams contentContainer = new RelativeLayout.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                contentContainer.width = dpToPx(724);
                contentContainer.topMargin = 25;
                contentContainer.addRule(BELOW, viewIdForRule1);
                contentContainer.addRule(ALIGN_LEFT, viewIdForRule1);
                return contentContainer;
            case ITEM_INDEX_BOX:
                RelativeLayout.LayoutParams itemIndexBox = new RelativeLayout.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                itemIndexBox.height = dpToPx(50);
                itemIndexBox.width = dpToPx(40);
                return itemIndexBox;
            case NAME_TEXT_VIEW:
                RelativeLayout.LayoutParams nameTextView = new RelativeLayout.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                nameTextView.addRule(RIGHT_OF, viewIdForRule1);
                nameTextView.leftMargin = 10;
                return nameTextView;
            case PROGRESS_TEXT_VIEW:
                RelativeLayout.LayoutParams progressTextView = new RelativeLayout.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                progressTextView.addRule(ALIGN_LEFT, viewIdForRule1);
                progressTextView.addRule(BELOW, viewIdForRule1);
                return progressTextView;
            case DIVIDER_LINE:
                RelativeLayout.LayoutParams dividerLine = new RelativeLayout.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                dividerLine.addRule(BELOW, viewIdForRule1);
                dividerLine.height = 1;
                dividerLine.width = dpToPx(724);
                dividerLine.topMargin = 18;
                return dividerLine;
            case DESCRIPTION_TEXT_VIEW:
                RelativeLayout.LayoutParams descriptionTextView = new RelativeLayout.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                descriptionTextView.addRule(ALIGN_LEFT, viewIdForRule1);
                descriptionTextView.addRule(BELOW, viewIdForRule1);
                descriptionTextView.topMargin = 11;
                return descriptionTextView;
            case BUTTON_CONTAINER:
                RelativeLayout.LayoutParams buttonContainer = new RelativeLayout.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                buttonContainer.width = dpToPx(80);
                buttonContainer.height = dpToPx(126);
                buttonContainer.rightMargin = 48;
                buttonContainer.addRule(ALIGN_TOP, viewIdForRule2);
                buttonContainer.addRule(ALIGN_RIGHT, viewIdForRule1);
                return buttonContainer;
            case BUTTON_IMAGE_VIEW:
                LinearLayout.LayoutParams buttonImageView = new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                buttonImageView.gravity = Gravity.CENTER;
                buttonImageView.topMargin = 27;
                return buttonImageView;
            case BUTTON_TEXT_VIEW:
                LinearLayout.LayoutParams buttonTextView = new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                buttonTextView.gravity = Gravity.CENTER;
                buttonTextView.topMargin = 15;
                return buttonTextView;
            default:
                return new RelativeLayout.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        }
    }

    private Drawable generateDrawable(int layoutType) {
        switch (layoutType) {
            case OUTER_BORDER:
                GradientDrawable outerBorder = new GradientDrawable();
                outerBorder.setColor(Color.WHITE);
                outerBorder.setCornerRadius(5);//TODO Attrs
                outerBorder.setStroke(3, Color.RED);//TODO Attrs
                return outerBorder;
            case POPUP_TAB:
                GradientDrawable popupTab = new GradientDrawable();
                popupTab.setColor(Color.RED);//TODO Attrs
                //top-left, top-right, bottom-right, bottom-left.
                popupTab.setCornerRadii(new float[]{5, 5,
                        5, 5,
                        0, 0,
                        0, 0});//TODO Attrs
                popupTab.setShape(GradientDrawable.RECTANGLE);
                return popupTab;
            case ITEM_INDEX_BOX:
            case BUTTON_CONTAINER:
                GradientDrawable containerBoxWithThemeColor = new GradientDrawable();
                containerBoxWithThemeColor.setColor(Color.BLUE); //TODO Module Theme in Attrs
                containerBoxWithThemeColor.setCornerRadius(5);//TODO Attrs
                return containerBoxWithThemeColor;
            default:
                return null;
        }
    }

    private int dpToPx(int dp) {
        float density = this.getResources()
                .getDisplayMetrics()
                .density;
        return Math.round((float) dp * density);
    }


}
