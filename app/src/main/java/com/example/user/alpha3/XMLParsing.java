package com.example.user.alpha3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class XMLParsing extends AppCompatActivity {

    private TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xmlparsing);

        txt = (TextView) findViewById(R.id.txt);
        parseXML();
    }

    private void parseXML() {
        XmlPullParserFactory parserFactory;
        try {
            parserFactory = XmlPullParserFactory.newInstance();
            XmlPullParser parser = parserFactory.newPullParser();
            InputStream is = getAssets().open("data.xml");
            parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
            parser.setInput(is, null);
            processParsing(parser);
        } catch (XmlPullParserException e) {

        } catch (IOException e) {
        }
    }

    private void processParsing(XmlPullParser parser) throws IOException, XmlPullParserException {
        ArrayList<Currency> currencys = new ArrayList<>();
        int eventType = parser.getEventType();
        Currency currentCurrency = null;

        while (eventType != XmlPullParser.END_DOCUMENT) {
            String eltCOIN = null;

            switch (eventType) {
                case XmlPullParser.START_TAG:
                    eltCOIN = parser.getName();

                    if ("COIN".equals(eltCOIN)) {
                        currentCurrency = new Currency();
                        currencys.add(currentCurrency);
                    } else if (currentCurrency != null) {
                        if ("NAME".equals(eltCOIN)) {
                            currentCurrency.NAME = parser.nextText();
                        } else if ("UNIT".equals(eltCOIN)) {
                            currentCurrency.UNIT = parser.nextText();
                        } else if ("CURRENCYCODE".equals(eltCOIN)) {
                            currentCurrency.CURRENCYCODE = parser.nextText();
                        } else if ("COUNTRY".equals(eltCOIN)) {
                            currentCurrency.COUNTRY = parser.nextText();
                        } else if ("RATE".equals(eltCOIN)) {
                            currentCurrency.RATE = parser.nextText();
                        } else if ("CHANGE".equals(eltCOIN)) {
                            currentCurrency.CHANGE = parser.nextText();
                        }
                    }
                    break;

            }
            eventType = parser.next();
        }
        printCurrencycs(currencys);
    }

    private void printCurrencycs(ArrayList<Currency> currencys){
        StringBuilder builder = new StringBuilder();
        for (Currency currency : currencys) {
            builder.append(currency.NAME).append("\n").
                    append(currency.UNIT).append("\n").
                    append(currency.CURRENCYCODE).append("\n").
                    append(currency.COUNTRY).append("\n").
                    append(currency.RATE).append("\n").
                    append(currency.CHANGE).append("\n\n");
        }
        txt.setText(builder.toString());

    }
}


