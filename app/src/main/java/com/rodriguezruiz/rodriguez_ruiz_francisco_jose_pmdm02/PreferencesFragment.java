package com.rodriguezruiz.rodriguez_ruiz_francisco_jose_pmdm02;
/**
 * Fragmento que gestiona las preferencias de la aplicación, específicamente
 * la configuración del idioma. Extiende PreferenceFragmentCompat para manejar
 * las preferencias de manera compatible con versiones anteriores de Android.
 */
import android.content.res.Configuration;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.preference.ListPreference;
import androidx.preference.PreferenceFragmentCompat;
import java.util.Locale;
/**
 * PreferencesFragment proporciona una interfaz para que el usuario pueda
 * seleccionar y cambiar el idioma de la aplicación. Los cambios se aplican
 * inmediatamente y persisten entre sesiones.
 */
public class PreferencesFragment extends PreferenceFragmentCompat {

    // El siguiente atributo define de forma estática el valor de la clave para el sharedPreferences
    private static final String KEY = "language";
    /**
     * Método llamado para crear las preferencias del fragmento.
     * Inicializa las preferencias desde el recurso XML y configura
     * el listener para los cambios de idioma.
     *
     * @param savedInstanceState Estado guardado del fragmento si está siendo recreado
     * @param rootKey Clave raíz de las preferencias, puede ser null
     */
    @Override
    public void onCreatePreferences(@Nullable Bundle savedInstanceState, @Nullable String rootKey) {
        setPreferencesFromResource(R.xml.preferences, rootKey);

        ListPreference listPreference = findPreference(KEY);
        if (listPreference != null) {
            listPreference.setOnPreferenceChangeListener((preference, newValue) -> {
                // Se procede a cambiar el idioma
                String languageCode = (String) newValue;
                updateLanguage(languageCode);
                return true;
            });
        }
    }

    /**
     * Actualiza el idioma de la aplicación según la selección del usuario.
     * Aplica el cambio de idioma y recrea la actividad para que los cambios
     * sean efectivos.
     *
     * @param languageCode Código del idioma seleccionado (ejemplo: "es" para español)
     */
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