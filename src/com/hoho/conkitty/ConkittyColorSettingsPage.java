package com.hoho.conkitty;

import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.options.colors.AttributesDescriptor;
import com.intellij.openapi.options.colors.ColorDescriptor;
import com.intellij.openapi.options.colors.ColorSettingsPage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.Map;

public class ConkittyColorSettingsPage implements ColorSettingsPage {
    private static final AttributesDescriptor[] DESCRIPTORS = new AttributesDescriptor[]{
            new AttributesDescriptor("Keyword", ConkittySyntaxHighlighter.KEYWORD),
            new AttributesDescriptor("Template name", ConkittySyntaxHighlighter.TEMPLATE_NAME),
            new AttributesDescriptor("Tag", ConkittySyntaxHighlighter.TAG),
            new AttributesDescriptor("Variable", ConkittySyntaxHighlighter.VARIABLE_NAME),
            new AttributesDescriptor("String", ConkittySyntaxHighlighter.STRING),
            new AttributesDescriptor("JavaScript", ConkittySyntaxHighlighter.JAVASCRIPT),
            new AttributesDescriptor("Comment", ConkittySyntaxHighlighter.COMMENT),
            new AttributesDescriptor("Bad character", ConkittySyntaxHighlighter.BAD_CHARACTER),
    };

    @Nullable
    @Override
    public Icon getIcon() {
        return ConkittyIcons.FILE;
    }

    @NotNull
    @Override
    public SyntaxHighlighter getHighlighter() {
        return new ConkittySyntaxHighlighter();
    }

    @NotNull
    @Override
    public String getDemoText() {
        return "// Hello from Conkitty\n" +
                "template1 arg1 arg2\n" +
                "    div.hello[what=\"world\"]\n" +
                "        CHOOSE\n" +
                "            WHEN (arg1)\n" +
                "                \"Crede firmiter et peca fortiter\"\n" +
                "            WHEN (arg2 instanceof Object)\n" +
                "                SET var (1 + 2 + 3)\n" +
                "                (var + 4)\n" +
                "            OTHERWISE\n" +
                "                CALL template2 ({aa: 'bb', cc: 'dd'})\n" +
                "                    h1\n" +
                "                        \"Hello world\"\n" +
                "\n" +
                "/* Another comment */\n" +
                "template2 data\n" +
                "    PAYLOAD\n" +
                "    ul\n" +
                "        EACH key val (data)\n" +
                "            li\n" +
                "                (key)\n" +
                "                \" — \"\n" +
                "                (val)\n" +
                "\n" +
                "!Bad input";
    }

    @Nullable
    @Override
    public Map<String, TextAttributesKey> getAdditionalHighlightingTagToDescriptorMap() {
        return null;
    }

    @NotNull
    @Override
    public AttributesDescriptor[] getAttributeDescriptors() {
        return DESCRIPTORS;
    }

    @NotNull
    @Override
    public ColorDescriptor[] getColorDescriptors() {
        return ColorDescriptor.EMPTY_ARRAY;
    }

    @NotNull
    @Override
    public String getDisplayName() {
        return "Conkitty";
    }
}
