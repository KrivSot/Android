package com.example.md;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.xpath.XPathException;

public class XMLPullParserHandler {
    List<kralove> kralove;
    private kralove kral;
    private String text;

    public XMLPullParserHandler() {
        kralove = new ArrayList<kralove>();
    }

    public  List<kralove> getKralove(){
        return kralove;
    }

    public  List<kralove> parse(InputStream is){
        XmlPullParserFactory factory = null;
        XmlPullParser parser = null;
        try {
            factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);
            parser = factory.newPullParser();
            parser.setInput(is,null);

            int typ = parser.getEventType();
            while (typ !=XmlPullParser.END_DOCUMENT){
                String tagName = parser.getName();
                switch (typ){
                    case XmlPullParser.START_TAG:
                        if (tagName.equalsIgnoreCase("kral")){
                            kral = new kralove();
                        }
                        break;

                    case XmlPullParser.TEXT:
                        text = parser.getText();
                        break;

                    case  XmlPullParser.END_TAG:
                        if (tagName.equalsIgnoreCase("kral")) {
                            kralove.add(kral);
                        }
                        else  if (tagName.equalsIgnoreCase("poradi")){
                            kral.setPoradi(text);
                        }
                        else  if (tagName.equalsIgnoreCase("jmeno")){
                            kral.setJmeno(text);
                        }
                        else  if (tagName.equalsIgnoreCase("zil")){
                            kral.setZil(text);
                        }
                        else  if (tagName.equalsIgnoreCase("vladnul")){
                            kral.setVladnul(text);
                        }
                        else  if (tagName.equalsIgnoreCase("poznamka")){
                            kral.setPoznamka(text);
                        }
                        break;

                    default:break;
                }
                typ = parser.next();
            }
        }
        catch (XmlPullParserException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return kralove;
    }
}
