package mx.dev.franco.musicallibraryorganizer;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

/**
 * Created by franco on 12/11/16.
 */

public class TypeScanDialogFragment extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        SplashActivity.sharedPreferences = getActivity().getSharedPreferences("ShaPreferences", Context.MODE_PRIVATE);
        // Se usa la clase Builder para la construccion del dialogo
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        final View formElementsView = inflater.inflate(R.layout.scan_dialog_elements, null, false);
        //final RadioGroup scanTypeRadioGroup = (RadioGroup) formElementsView.findViewById(R.id.scanTypeRadioGroup);
        final Button autoButton = (Button)formElementsView.findViewById(R.id.autoScanRadio);
        final Button manualButton = (Button)formElementsView.findViewById(R.id.manualScanRadio);

        builder.setView(formElementsView).setMessage(R.string.title_scantype_dialog);
        /*scanTypeRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int id){

                if(id == R.id.autoScanRadio) {
                    scanRequestType = 1;
                } else if(id == R.id.manualScanRadio) {
                    scanRequestType = 2;
                }
                new CountDownTimer(1000, 1000) {
                    public void onTick(long millisUntilFinished) {}

                    public void onFinish() {
                        getDialog().cancel();
                        ((SelectFolderActivity)getActivity()).progressBar.setVisibility(View.VISIBLE);
                        askForPermission(Manifest.permission.READ_EXTERNAL_STORAGE,scanRequestType);

                    }
                }.start();

            }
        });*/

        // Se crea el Dialog y se retorna
        return builder.create();
    }



}
