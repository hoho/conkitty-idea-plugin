package com.hoho.conkitty;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class ConkittyFileType extends LanguageFileType {
    public static final ConkittyFileType INSTANCE = new ConkittyFileType();

    private ConkittyFileType() {
        super(ConkittyLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public String getName() {
        return "Conkitty file";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "Conkitty templates file";
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
        return "ctpl";
    }

    @Nullable
    @Override
    public Icon getIcon() {
        return ConkittyIcons.FILE;
    }
}
