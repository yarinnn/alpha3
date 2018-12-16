package com.example.user.alpha3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class XMLParsing extends AppCompatActivity {
 /*   XML PARSE IS NOT WORKING
 XmlPullParser parser = XmlPullParserFactory.newInstance().newPullParser();
    String rates_url="https://www.boi.org.il/currency.xml";
    URL url = new URL(rates_url);
    int event;
    TextView test;
    public XMLParsing() throws XmlPullParserException, MalformedURLException {
    }
*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xmlparsing);


/*        XML PARSE IS NOT WORKING
        test= (TextView)findViewById(R.id.test);

        try {
            parser.setInput(url.openStream() , null);
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            event = parser.getEventType();
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }

        while (event != XmlPullParser.END_DOCUMENT){
            try {
                event=parser.next();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (XmlPullParserException e) {
                e.printStackTrace();
            }
        }
*/



    }
}
