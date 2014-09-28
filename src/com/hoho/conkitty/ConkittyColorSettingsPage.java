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
            new AttributesDescriptor("Command", ConkittySyntaxHighlighter.COMMAND_NAME),
            new AttributesDescriptor("Template", ConkittySyntaxHighlighter.TEMPLATE_NAME),
            new AttributesDescriptor("Tag", ConkittySyntaxHighlighter.TAG),
            new AttributesDescriptor("Variable", ConkittySyntaxHighlighter.VARIABLE_NAME),
            new AttributesDescriptor("String", ConkittySyntaxHighlighter.STRING),
            new AttributesDescriptor("JavaScript", ConkittySyntaxHighlighter.JAVASCRIPT),
            new AttributesDescriptor("Comment", ConkittySyntaxHighlighter.COMMENT),
            new AttributesDescriptor("Comma", ConkittySyntaxHighlighter.COMMA),
            new AttributesDescriptor("Bracket", ConkittySyntaxHighlighter.BRACKET),
            new AttributesDescriptor("Conditional", ConkittySyntaxHighlighter.PSEUDO),
            new AttributesDescriptor("Assign", ConkittySyntaxHighlighter.ASSIGN),
            new AttributesDescriptor("Dependency", ConkittySyntaxHighlighter.INCLUDE),
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
                "template1 $arg1 $arg2=\"mimimi\"\n" +
                "    div.hello[what=\"world\"]:if($arg2, .yes)\n" +
                "        CHOOSE\n" +
                "            WHEN $arg1\n" +
                "                \"Crede firmiter et peca fortiter\"\n" +
                "            WHEN ($arg2 instanceof Object)\n" +
                "                SET $somevar (1 + 2 + 3)\n" +
                "                ($somevar + 4)\n" +
                "            OTHERWISE\n" +
                "                CALL template2 ({aa: 'bb', cc: 'dd'})\n" +
                "                    h1\n" +
                "                        \"Hello world\"\n" +
                "\n" +
                "/* Another\n" +
                "     comment */\n" +
                "template2 $data\n" +
                "    &\"file.css\"\n" +
                "\n" +
                "    PAYLOAD\n" +
                "    ul AS $node\n" +
                "        EACH $key $val $data\n" +
                "            li\n" +
                "                $key\n" +
                "                \" — \"\n" +
                "                $val\n" +
                "    EXPOSE JS\n" +
                "        return {list: $node}";
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
