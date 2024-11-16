package com.rodriguezruiz.rodriguez_ruiz_francisco_jose_pmdm02;

import android.content.res.Configuration;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.preference.ListPreference;
import androidx.preference.PreferenceFragmentCompat;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Locale;

public class PreferencesFragment extends PreferenceFragmentCompat {

    @Override
    public void onCreatePreferences(@Nullable Bundle savedInstanceState, @Nullable String rootKey) {
        setPreferencesFromResource(R.xml.preferences, rootKey);

        ListPreference listPreference = findPreference("language");
        if (listPreference != null) {
            listPreference.setOnPreferenceChangeListener((preference, newValue) -> {
                // Se procede a cambiar el idioma
                String languageCode = (String) newValue;
                updateLanguage(languageCode);
                return true;
            });
        }
    }

    private void updateLanguage(String languageCode) {
        Locale locale = new Locale(languageCode);
        Locale.setDefault(locale);

        Configuration configuration = new Configuration();
        configuration.setLocale(locale);

        requireActivity().getResources().updateConfiguration(configuration, requireActivity().getResources().getDisplayMetrics());

        // Reiniciar la activity para que tengan lugar los cambios de idioma
        requireActivity().recreate();
    }
}