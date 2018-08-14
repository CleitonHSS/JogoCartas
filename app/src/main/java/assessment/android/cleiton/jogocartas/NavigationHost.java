package assessment.android.cleiton.jogocartas;

import android.support.v4.app.Fragment;

public interface NavigationHost {
    void navigateTo(Fragment fragment, boolean addToBackstack);
}
