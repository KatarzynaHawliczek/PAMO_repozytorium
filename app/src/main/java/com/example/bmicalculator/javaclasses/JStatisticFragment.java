//package com.example.bmicalculator.javaclasses;
//
//import android.os.Bundle;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.webkit.WebSettings;
//import android.webkit.WebView;
//
//import androidx.annotation.NonNull;
//import androidx.annotation.Nullable;
//import androidx.fragment.app.Fragment;
//
//import com.example.bmicalculator.R;
//
//public class JStatisticFragment extends Fragment {
//
//    public JStatisticFragment() {
//
//    }
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//
//        super.onCreate(savedInstanceState);
//    }
//
//    @Nullable
//    @Override
//    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//
//        return inflater.inflate(R.layout.fragment_statistic, container, false);
//    }
//
//    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
//
//        WebView myWebView = view.findViewById(R.id.wykres);
//        WebSettings webSettings = myWebView.getSettings();
//        webSettings.setJavaScriptEnabled(true);
//
//        String wykres =
//                "<html>\n"
//        +       "  <head>\n"
//        +       "    <script type=\"text/javascript\" src=\"https://www.gstatic.com/charts/loader.js\"></script>\n"
//        +       "    <script type=\"text/javascript\">\n"
//        +       "      google.charts.load('current', {'packages':['bar']});\n"
//        +       "      google.charts.setOnLoadCallback(drawChart);\n"
//        +       "      function drawChart() {\n"
//        +       "        var data = google.visualization.arrayToDataTable([\n"
//        +       "          ['Państwo', 'Zachorowania', 'Zgony', 'Wyleczenia'],\n"
//        +       "          ['USA', 180271, 3573, 6241],\n"
//        +       "          ['Włochy', 105792, 12428, 15729],\n"
//        +       "          ['Hiszpania', 94417, 8269, 19259],\n"
//        +       "          ['Chiny', 81518, 3305, 76052],\n"
//        +       "          ['Niemcy', 68180, 682, 15824],\n"
//        +       "          ['Francja', 52128, 3523, 9444],\n"
//        +       "          ['Wielka Brytania', 25150, 1789, 135],\n"
//        +       "          ['Polska', 2311, 33, 7]\n"
//        +       "        ]);\n"
//        +       "\n"
//        +       "        var options = {\n"
//        +       "          chart: {\n"
//        +       "            title: 'Statystyki koronawirusa',\n"
//        +       "            subtitle: 'Zachorowania, Zgony i Wyleczenia: 31.03.2020',\n"
//        +       "          }\n"
//        +       "        };\n"
//        +       "\n"
//        +       "        var chart = new google.charts.Bar(document.getElementById('columnchart_material'));\n"
//        +       "        chart.draw(data, google.charts.Bar.convertOptions(options));\n"
//        +       "      }\n"
//        +       "    </script>\n"
//        +       "  </head>\n"
//        +       "  <body>\n"
//        +       "    <div id=\"columnchart_material\" style=\"width: 800px; height: 500px;\"></div>\n"
//        +       "  </body>\n"
//        +       "</html>\n";
//
//        myWebView.loadData(wykres, "text/html", "UTF-8");
//    }
//}
