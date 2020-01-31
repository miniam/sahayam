package com.example.sahayam.ui.gallery;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class GalleryViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public GalleryViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Ayurveda\n\n" +
                "\n" +
                "“AYURVEDA” is made up of two words- Ayuh and Veda. Ayuh means life and Veda means knowledge or science. Thus “AYURVEDA’ in totality means ‘Science of life’. It incorporates all aspects of life whether physical, psychological, spiritual or social. What is beneficial and what is harmful to life, what is happy life and what is sorrowful life; all these four questions and life span allied issues are elaborately and emphatically discussed in Ayurveda.\n" +
                "\n" +
                "Origin of Ayurveda\n\n" +
                "\n" +
                "Ayurveda is considered as one of the ancient health care system. The antique vedic texts have scattered references of Ayurvedic Remedies and allied aspects of medicine and health. Atharva-veda mainly deals with extensive Ayurvedic information. That is why Ayurveda is said to be the off shoot of Atharva Veda. Ayurveda is the system of medicine that evolved in India with a rationale logical foundation and it has survived as a distinct entity from remote antiquity to the present day. The fundamentals on which the Ayurvedic system is based are essentially true for all times and do not change from are to age. These are based on human actors, on intrinsic causes. The origin of Ayurveda is attributed to Atharva Veda where mention is made several diseases with their treatments. Later, from the 6th Century BC to 7th Century AD there was systematic development of the science and it is called Samhita period, when a number of classical works were produced by several authors and during this period there is evidence of organized medical care.\n" +
                "\n" +
                "Branches of Ayurveda\n\n" +
                "\n" +
                "The Ayurvedic classics describe eight well developed clinical branches of Ayurveda:\n" +
                "\n" +
                "1)Kaya Chikitsa- Medicine\n" +
                "2)Shalya Tantra- Surgery\n" +
                "3)Shalakya Tantra- ENT and Opthalamology\n" +
                "4)Kaumarbhritya- Paediatrics and Obstretics\n" +
                "5)Agad Tantra- Toxicology\n" +
                "6)Bhut Vidya- Psychiatry\n" +
                "7)Rasayan- Rejuvenation therapy and geriatrics\n" +
                "8)Vajikaran- Sexology (Including Aphrodisiac for better progeny )\n\n" +
                "ESTABLISHMENT OF AIIA\n\n" +
                "The All India Institute of Ayurveda has been conceived as an Apex Institute for Ayurveda. It aims at bringing a synergy between Traditional Wisdom of Ayurveda and Modern tools and technology. The institute would offer postgraduate and doctoral courses in various disciplines of Ayurveda and will focus on fundamental research of Ayurveda, drug development, standardization, quality control, safety evaluation and scientific validation of Ayurvedic medicine. Institute has a 200 bed referral hospital for facilitating clinical research. The Institute has 25 Specialty Departments and 12 clinics with 8 inter-disciplinary research laboratories wherein several Scholars  have access for PG & Ph.D programs every year. The hospital is equipped with state of the art modern diagnostic tools and techniques which is used in teaching, training and research. The patient care is done primarily through Ayurveda of tertiary level. This institute also has an international collaborative centre for global promotion and research in Ayurveda.\n" +
                "\n" +
                "Historic Moments");
    }

    public LiveData<String> getText() {
        return mText;
    }
}