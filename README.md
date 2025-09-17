<img width="1080" height="1920" alt="headr2" src="https://github.com/user-attachments/assets/19363afc-7a92-4a85-9fa1-6fa11f5cf4cd" /><img width="1080" height="1920" alt="headr2" src="https://github.com/user-attachments/assets/407c23b1-dc53-4e0c-b4fd-2d8cfb2af6ef" /># 🔥 StopFire App

**Protect Your House – Battery & Fire Safety Monitoring App**
Monitor your phone’s battery health in real time to prevent overheating and fire hazards.

<img width="1920" height="1080" alt="2" src="https://github.com/user-attachments/assets/a8c1e728-7cd2-4ff1-91e3-a0e992e4bdf9" />

---

<img width="1080" height="2400" alt="Screenshot_20250708_235434" src="https://github.com/user-attachments/assets/3d9ae999-75ca-412e-a5e0-352e21e1d74f" />

---

<img width="720" height="1280" alt="head2" src="https://github.com/user-attachments/assets/2e0805b1-67e3-443e-8028-289ba0f72d3e" />

---

<img width="1080" height="2400" alt="Screenshot_20250704_224606" src="https://github.com/user-attachments/assets/a7b644bd-43e8-41d2-a3cf-4852094aeeb8" />

---

## 📌 Features

* 🔋 **Real-Time Battery Monitoring**
  Displays battery level, voltage, temperature, and charging state.
* ⚡ **Charger State Detection**
  Detects whether the device is charging or unplugged.
* 🌡 **Temperature Control**
  Alerts user when the battery overheats.
* 🛑 **StopFire Alert**
  Notifies you to unplug the charger when battery reaches **100%** to reduce fire risk.
* 🖥 **Modern UI**
  Simple, clean, and responsive interface with real-time updates.

---

## 🖼 Screenshots

| Battery Status                     | Full Charge Alert           | Website Preview              |
| ---------------------------------- | --------------------------- | ---------------------------- |
| ![Battery 90%](<img width="1080" height="1920" alt="headr2" src="https://github.com/user-attachments/assets/6aae8939-75b8-4070-9a40-871f5692286b" />) | ![Full 100%](![Uploading Screenshot_20250709_004703.png…]()
) | ![Website](docs/landing.png) |

---

## 🛠 Tech Stack

* **Kotlin (Android)** – Main programming language
* **Android Jetpack** – Lifecycle & WorkManager
* **BroadcastReceiver** – Battery state monitoring
* **ViewBinding** – Modern UI binding

---

## 📂 Project Structure

```
com.example.protectyourhousekotlin
 ┣ MainActivity.kt        # Main activity with UI + battery receiver
 ┣ MyWorker.kt            # WorkManager task for background checks
 ┣ res/layout             # XML layouts
 ┣ res/drawable           # Icons & UI assets
 ┗ AndroidManifest.xml    # Permissions & app config
```

---

## 🚀 Installation

1. Clone this repo:

   ```bash
   git clone https://github.com/ElouakfaouiYassine/Protect-Your-House-App.git
   cd StopFireApp
   ```
2. Open in **Android Studio**.
3. Run the app on an emulator or a physical Android device.

---

## 📖 Usage

* Open the app → You’ll see **battery percentage, temperature, voltage, and charger state**.
* When the battery is **full (100%)**, the app sends an alert:

  > *“Battery Full – Please unplug your charger.”*
* Helps avoid **overcharging** and potential **fire hazards**.

---

## 👤 Author

**Yassine Elouakfaoui**
🔗 [LinkedIn](https://www.linkedin.com/in/yassine-elouakfaoui/)

---

## 📜 License

This project is licensed under the MIT License.
