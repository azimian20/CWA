
/*
 * Copyright 2016 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/*

import com.google.cloud.translate.Detection;
import com.google.cloud.translate.Language;
import com.google.cloud.translate.Translate;
import com.google.cloud.translate.Translate.LanguageListOption;
import com.google.cloud.translate.Translate.TranslateOption;
import com.google.cloud.translate.TranslateOptions;
import com.google.cloud.translate.Translation;
import com.google.common.collect.ImmutableList;



import java.io.PrintStream;
import java.util.List;
import java.util.Optional;
*/
package com.jon;

import com.google.cloud.translate.Translate;
import com.google.cloud.translate.Translate.TranslateOption;
import com.google.cloud.translate.TranslateOptions;
import com.google.cloud.translate.Translation;

public class TranslateText {
	Translate translate = TranslateOptions.builder().apiKey("AIzaSyB055HVDu3pnlo5HGcriVq78HFqCC5uwFE").build()
			.service();

	public String translate(String sourceText, String sourceLanguage, String destLanguage) {
		Translation translation = translate.translate(sourceText, TranslateOption.sourceLanguage(sourceLanguage),
				TranslateOption.targetLanguage(destLanguage));
		return translation.translatedText();
	}
}