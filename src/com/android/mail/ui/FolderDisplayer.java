/*
 * Copyright (C) 2012 Google Inc.
 * Licensed to The Android Open Source Project.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.mail.ui;

import com.android.mail.utils.LogTag;
import com.google.common.collect.Sets;

import android.content.Context;

import com.android.mail.R;
import com.android.mail.providers.Conversation;
import com.android.mail.providers.Folder;

import java.util.SortedSet;

/**
 * Used to generate folder display information given a raw folders string.
 * (The raw folders string can be obtained from {@link Conversation#rawFolders}.)
 *
 */
public class FolderDisplayer {
    public static final String LOG_TAG = LogTag.getLogTag();
    protected Context mContext;
    protected final SortedSet<Folder> mFoldersSortedSet = Sets.newTreeSet();

    protected final int mDefaultBgColor;
    protected final int mDefaultFgColor;

    public FolderDisplayer(Context context) {
        mContext = context;

        mDefaultFgColor = context.getResources().getColor(R.color.default_folder_foreground_color);
        mDefaultBgColor = context.getResources().getColor(R.color.default_folder_background_color);
    }

    /**
     * Configure the FolderDisplayer object by parsing the rawFolders string.
     *
     * @param foldersString string containing serialized folders to display.
     * @param ignoreFolder (optional) folder to omit from the displayed set
     */
    public void loadConversationFolders(Conversation conv, Folder ignoreFolder) {
        mFoldersSortedSet.clear();
        mFoldersSortedSet.addAll(conv.getRawFoldersForDisplay(ignoreFolder));
    }

}
