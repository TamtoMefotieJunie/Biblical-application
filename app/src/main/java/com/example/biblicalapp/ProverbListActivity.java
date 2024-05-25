package com.example.biblicalapp;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProverbListActivity extends AppCompatActivity {

    private LinearLayout proverbsLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proverbs);

        proverbsLayout = findViewById(R.id.proverbsLayout);

        // Receive the selected category from intent
        String selectedCategory = getIntent().getStringExtra("category");

        // Display proverbs based on the selected category
        displayProverbs(selectedCategory);
    }

    private void displayProverbs(String selectedCategory) {
        List<String> proverbs = new ArrayList<>();

        // Add proverbs based on the selected category
        switch (selectedCategory) {
            case "Wisdom and Knowledge":
                proverbs.addAll(Arrays.asList(
                        "A wise son brings joy to his father, but a foolish son brings grief to his mother. - Proverbs 10:1",
                        "The fear of the LORD is the beginning of wisdom, and knowledge of the Holy One is understanding. - Proverbs 9:10",
                        "Get wisdom, get understanding; do not forget my words or turn away from them. - Proverbs 4:5",
                        "For wisdom will enter your heart, and knowledge will be pleasant to your soul. - Proverbs 2:10",
                        "The way of fools seems right to them, but the wise listen to advice. - Proverbs 12:15"
                ));
                break;
            case "Righteousness and Justice":
                proverbs.addAll(Arrays.asList(
                        "The LORD detests lying lips, but he delights in people who are trustworthy. - Proverbs 12:22",
                        "Whoever pursues righteousness and love finds life, prosperity, and honor. - Proverbs 21:21",
                        "The lips of the righteous nourish many, but fools die for lack of sense. - Proverbs 10:21",
                        "The wicked accept bribes in secret to pervert the course of justice. - Proverbs 17:23",
                        "A good person leaves an inheritance for their children’s children, but a sinner’s wealth is stored up for the righteous. - Proverbs 13:22"
                ));
                break;
            case "Love and Compassion":
                proverbs.addAll(Arrays.asList(
                        "Hatred stirs up conflict, but love covers over all wrongs. - Proverbs 10:12",
                        "Love and faithfulness keep a king safe; through love his throne is made secure. - Proverbs 20:28",
                        "A friend loves at all times, and a brother is born for a time of adversity. - Proverbs 17:17",
                        "Let love and faithfulness never leave you; bind them around your neck, write them on the tablet of your heart. - Proverbs 3:3",
                        "A gentle answer turns away wrath, but a harsh word stirs up anger. - Proverbs 15:1"
                ));
                break;
            case "Faith and Hope":
                proverbs.addAll(Arrays.asList(
                        "Now faith is confidence in what we hope for and assurance about what we do not see. - Hebrews 11:1",
                        "But now these three remain: faith, hope, and love. But the greatest of these is love. - 1 Corinthians 13:13",
                        "May the God of hope fill you with all joy and peace as you trust in him, so that you may overflow with hope by the power of the Holy Spirit. - Romans 15:13",
                        "For in this hope we were saved. But hope that is seen is no hope at all. Who hopes for what they already have? - Romans 8:24",
                        "Be joyful in hope, patient in affliction, faithful in prayer. - Romans 12:12"
                ));
                break;
            case "Courage and Strength":
                proverbs.addAll(Arrays.asList(
                        "Be strong and courageous. Do not be afraid; do not be discouraged, for the LORD your God will be with you wherever you go. - Joshua 1:9",
                        "But those who hope in the LORD will renew their strength. They will soar on wings like eagles; they will run and not grow weary, they will walk and not be faint. - Isaiah 40:31",
                        "Finally, be strong in the Lord and in his mighty power. - Ephesians 6:10",
                        "The LORD is my strength and my shield; my heart trusts in him, and he helps me. My heart leaps for joy, and with my song I praise him. - Psalm 28:7",
                        "I can do all this through him who gives me strength. - Philippians 4:13"
                ));
                break;
            case "Humility and Pride":
                proverbs.addAll(Arrays.asList(
                        "When pride comes, then comes disgrace, but with humility comes wisdom. - Proverbs 11:2",
                        "Pride goes before destruction, a haughty spirit before a fall. - Proverbs 16:18",
                        "Do nothing out of selfish ambition or vain conceit. Rather, in humility value others above yourselves. - Philippians 2:3",
                        "Humble yourselves before the Lord, and he will lift you up. - James 4:10",
                        "But he gives us more grace. That is why Scripture says: 'God opposes the proud but shows favor to the humble.' - James 4:6"
                ));
                break;
            case "Wealth and Poverty":
                proverbs.addAll(Arrays.asList(
                        "Better a little with the fear of the LORD than great wealth with turmoil. - Proverbs 15:16",
                        "The rich rule over the poor, and the borrower is slave to the lender. - Proverbs 22:7",
                        "A good person leaves an inheritance for their children’s children, but a sinner’s wealth is stored up for the righteous. - Proverbs 13:22",
                        "The wealth of the rich is their fortified city; they imagine it a wall too high to scale. - Proverbs 18:11",
                        "Whoever oppresses the poor shows contempt for their Maker, but whoever is kind to the needy honors God. - Proverbs 14:31"
                ));
                break;
            case "Friendship and Relationship":
                proverbs.addAll(Arrays.asList(
                        "A friend loves at all times, and a brother is born for a time of adversity. - Proverbs 17:17",
                        "As iron sharpens iron, so one person sharpens another. - Proverbs 27:17",
                        "Do not forsake your friend or a friend of your family, and do not go to your relative’s house when disaster strikes you— better a neighbor nearby than a relative far away. - Proverbs 27:10",
                        "A perverse person stirs up conflict, and a gossip separates close friends. - Proverbs 16:28",
                        "A friend is always loyal, and a brother is born to help in time of need. - Proverbs 17:17"
                ));
                break;
            case "Anger and Patience":
                proverbs.addAll(Arrays.asList(
                        "Fools give full vent to their rage, but the wise bring calm in the end. - Proverbs 29:11",
                        "A hot-tempered person stirs up conflict, but the one who is patient calms a quarrel. - Proverbs 15:18",
                        "Refrain from anger and turn from wrath; do not fret—it leads only to evil. - Psalm 37:8",
                        "My dear brothers and sisters, take note of this: Everyone should be quick to listen, slow to speak and slow to become angry"
                ));
                break;
            default:
                // Handle unknown category
                break;
        }
                        // Display proverbs in the layout
        for (String proverb : proverbs) {
            TextView proverbView = new TextView(this);
            proverbView.setText(proverb);
            proverbView.setTextSize(20);
            proverbView.setPadding(10, 30, 10, 10);
            proverbsLayout.addView(proverbView);
        }
    }
}
