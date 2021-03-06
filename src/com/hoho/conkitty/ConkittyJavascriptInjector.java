package com.hoho.conkitty;

import com.hoho.conkitty.psi.ConkittyTypes;
import com.intellij.lang.Language;
import com.intellij.openapi.fileTypes.FileTypeManager;
import com.intellij.openapi.fileTypes.LanguageFileType;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.*;
import org.jetbrains.annotations.NotNull;


public class ConkittyJavascriptInjector implements LanguageInjector {
    public void getLanguagesToInject(@NotNull PsiLanguageInjectionHost host, @NotNull InjectedLanguagePlaces injectionPlacesRegistrar) {
        if (host.getNode().getElementType() == ConkittyTypes.JAVASCRIPT) {
            final String text = host.getText();
            final Language language = ((LanguageFileType)FileTypeManager.getInstance().getFileTypeByExtension("js")).getLanguage();
            injectionPlacesRegistrar.addPlace(language, new TextRange(0, text.length()), "(function(){ return ", "})()");
        }
    }
}
