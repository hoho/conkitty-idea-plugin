package com.hoho.conkitty.psi;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import com.hoho.conkitty.ConkittyFileType;
import com.hoho.conkitty.ConkittyLanguage;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class ConkittyFile extends PsiFileBase {
    public ConkittyFile(@NotNull FileViewProvider viewProvider) {
        super(viewProvider, ConkittyLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public FileType getFileType() {
        return ConkittyFileType.INSTANCE;
    }

    @Override
    public String toString() {
        return "Conkitty File";
    }

    @Override
    public Icon getIcon(int flags) {
        return super.getIcon(flags);
    }
}
