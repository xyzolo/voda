package com.View;

import com.vdurmont.emoji.EmojiParser;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

// refactor this for "Controllers" and all logik extract out
public class Keyboards {
    public void start(long tid) {
        System.out.println("RezultDiary:start");
    }

    public ReplyKeyboardMarkup getDefaultDiaryKeybord() {

        List<KeyboardRow> keyboard = new ArrayList<KeyboardRow>();

        KeyboardRow row = new KeyboardRow();

        KeyboardButton voda = new KeyboardButton(EmojiParser.parseToUnicode(":potable_water:"));
        KeyboardButton eda = new KeyboardButton(EmojiParser.parseToUnicode(":green_salad:"));
        KeyboardButton activity = new KeyboardButton(EmojiParser.parseToUnicode(":ping_pong:"));
        KeyboardButton daily = new KeyboardButton(EmojiParser.parseToUnicode(":chart_with_downwards_trend:"));
        KeyboardButton weakly = new KeyboardButton(EmojiParser.parseToUnicode(":bar_chart:"));
        KeyboardButton mounthly = new KeyboardButton(EmojiParser.parseToUnicode(":date:"));
        KeyboardButton promotions = new KeyboardButton(EmojiParser.parseToUnicode(":star:"));
        KeyboardButton back = new KeyboardButton(EmojiParser.parseToUnicode(":leftwards_arrow_with_hook:"));

        row.add(back);
        row.add(voda);
        row.add(eda);
        row.add(activity);
        row.add(daily);
        row.add(weakly);
        row.add(mounthly);
        row.add(promotions);

        keyboard.add(row);

        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup().setResizeKeyboard(true);

        keyboardMarkup.setKeyboard(keyboard).setSelective(true);

        return keyboardMarkup;

    }

    public ReplyKeyboardMarkup getDefaultWaterDiaryKeybord() {

        List<KeyboardRow> keyboard = new ArrayList<KeyboardRow>();

        KeyboardRow row = new KeyboardRow();

        KeyboardButton plus = new KeyboardButton(EmojiParser.parseToUnicode(":heavy_plus_sign:"));
        KeyboardButton minus = new KeyboardButton(EmojiParser.parseToUnicode(":heavy_minus_sign:"));
        KeyboardButton all = new KeyboardButton(EmojiParser.parseToUnicode(":question:"));
        KeyboardButton back = new KeyboardButton(EmojiParser.parseToUnicode(":leftwards_arrow_with_hook:"));

        row.add(plus);
        // row.add(minus);
        row.add(all);
        // row.add(back);

        keyboard.add(row);

        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup().setResizeKeyboard(true);

        keyboardMarkup.setKeyboard(keyboard).setSelective(true);

        return keyboardMarkup;

    }

    public ReplyKeyboardMarkup getDefaultAnswerWaterDiaryKeybord() {

        List<KeyboardRow> keyboard = new ArrayList<KeyboardRow>();

        KeyboardRow row = new KeyboardRow();
        KeyboardRow row1 = new KeyboardRow();
        KeyboardRow row2 = new KeyboardRow();
        KeyboardRow row3 = new KeyboardRow();

        KeyboardButton one = new KeyboardButton(EmojiParser.parseToUnicode("100"));
        KeyboardButton two = new KeyboardButton(EmojiParser.parseToUnicode("200"));
        KeyboardButton three = new KeyboardButton(EmojiParser.parseToUnicode("250"));
        KeyboardButton four = new KeyboardButton(EmojiParser.parseToUnicode("300"));
        KeyboardButton five = new KeyboardButton(EmojiParser.parseToUnicode("400"));
        KeyboardButton six = new KeyboardButton(EmojiParser.parseToUnicode("500"));
        KeyboardButton seven = new KeyboardButton(EmojiParser.parseToUnicode("750"));
        KeyboardButton eight = new KeyboardButton(EmojiParser.parseToUnicode("1000"));
        KeyboardButton nine = new KeyboardButton(EmojiParser.parseToUnicode("2000"));
        KeyboardButton zero = new KeyboardButton(EmojiParser.parseToUnicode("0"));
        KeyboardButton doted = new KeyboardButton(EmojiParser.parseToUnicode("..."));
        KeyboardButton back = new KeyboardButton(EmojiParser.parseToUnicode(":leftwards_arrow_with_hook:"));

        row.add(one);
        row1.add(two);
        row2.add(three);
        row.add(four);
        row1.add(five);
        row2.add(six);
        row.add(seven);
        row1.add(eight);
        row2.add(nine);
        row3.add(doted);
        row3.add(zero);
        row3.add(back);

        keyboard.add(row);
        keyboard.add(row1);
        keyboard.add(row2);
        keyboard.add(row3);

        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup().setResizeKeyboard(true);

        keyboardMarkup.setKeyboard(keyboard).setSelective(true);

        return keyboardMarkup;

    }

    public ReplyKeyboardMarkup getDefaultFitActivityKeybord() {
        List<KeyboardRow> keyboard = new ArrayList<KeyboardRow>();

        KeyboardRow row = new KeyboardRow();

        KeyboardButton one = new KeyboardButton("Да");
        KeyboardButton two = new KeyboardButton("Нет");

        row.add(one);
        row.add(two);

        keyboard.add(row);

        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup().setResizeKeyboard(true);

        keyboardMarkup.setKeyboard(keyboard).setSelective(true);

        return keyboardMarkup;

    }

    public ReplyKeyboardMarkup getDefaultPlankActivityKeybord() {
        List<KeyboardRow> keyboard = new ArrayList<KeyboardRow>();

        KeyboardRow row = new KeyboardRow();

        KeyboardButton one = new KeyboardButton("Да");
        KeyboardButton two = new KeyboardButton("Нет");

        row.add(one);
        row.add(two);

        keyboard.add(row);

        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup().setResizeKeyboard(true);

        keyboardMarkup.setKeyboard(keyboard).setSelective(true);

        return keyboardMarkup;

    }

    public ReplyKeyboardMarkup getDefaultStatisticakActivityKeybord() {
        List<KeyboardRow> keyboard = new ArrayList<KeyboardRow>();

        KeyboardRow row = new KeyboardRow();

        KeyboardButton one = new KeyboardButton("Да");
        KeyboardButton two = new KeyboardButton("Нет");

        row.add(one);
        row.add(two);

        keyboard.add(row);

        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup().setResizeKeyboard(true);

        keyboardMarkup.setKeyboard(keyboard).setSelective(true);

        return keyboardMarkup;

    }

    public String startMessage(long tid) {
        return "Привет! Хочешь записывать воду?";
    }

}
