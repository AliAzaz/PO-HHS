package edu.aku.hassannaqvi.uen_po_hhs_fl.otherClasses;

import android.app.Activity;
import android.support.design.widget.Snackbar;
import android.view.ViewGroup;

/**
 * Created by ali.azaz on 22/04/2019.
 */

public class SnackUtils {

    public static Snackbar showLoadingSnackbar(Activity ctx, String message) {
        final ViewGroup viewGroup = (ViewGroup) ((ViewGroup) ctx.findViewById(android.R.id.content)).getChildAt(0);
        Snackbar bar = Snackbar.make(viewGroup, message, Snackbar.LENGTH_INDEFINITE);
        bar.show();
        return bar;
    }
}