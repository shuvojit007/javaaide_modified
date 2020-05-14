/*
 * Copyright (C) 2018 Tran Le Duy
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package com.duy.ide.javaide.editor.autocomplete.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.duy.ide.editor.view.IEditAreaView;

public class KeywordDescription extends JavaSuggestItemImpl {
    private final String keyword;

    public KeywordDescription(String keyword) {
        this.keyword = keyword;
    }

    @Nullable
    @Override
    public String getName() {
        return keyword;
    }

    @Nullable
    @Override
    public String getDescription() {
        return null;
    }

    @Nullable
    @Override
    public String getReturnType() {
        return null;
    }

    @Override
    public char getTypeHeader() {
        return 0;
    }

    @Override
    public void onSelectThis(@NonNull IEditAreaView iEditAreaView) {
        //always add space
        insertImpl(iEditAreaView, keyword + " ");
    }
}